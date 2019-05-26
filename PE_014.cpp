#include <iostream>
#include <vector>
using namespace std;

/*
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * SOLUTION: 837799
 */

class LinkedList{
private:
  struct Item{
    long int numberInSequence;
    int terms;
    Item* nextItem;
  };
  Item* head;
public:
  LinkedList(){
    head = NULL;
  }
  void insertItem(long int number, int numOfTerms){
    Item* newItem = new Item{number, numOfTerms, NULL};
    if(head == NULL)
      head = newItem;
    else{
      newItem->nextItem = head;
      head = newItem;
    }
  }
  //searches for number in sequence in linked list
  //returns number of terms for the number if number is there, otherwise returns -1
  int searchForItem(int number){
    Item* currentItem = head;
    while(currentItem != NULL){
      if(currentItem->numberInSequence == number)
        return currentItem->terms;
      currentItem = currentItem->nextItem;
    }
    return -1;
  }
  ~LinkedList(){
    Item* currentItem = head;
    Item* nextItem;
    while(currentItem != NULL){
      nextItem = currentItem->nextItem;\
      delete currentItem;
      currentItem = nextItem;
    }
  }
};

class HashTable{
private:
  int numberOfBuckets;
  vector<LinkedList*> buckets;
public:
  HashTable(int numBuckets){
    numberOfBuckets = numBuckets;
    for(int i = 0; i < numberOfBuckets; i++)
      buckets.push_back(new LinkedList);
  }
  void insertItem(long int number, int terms){
    int bucketNumber = number % numberOfBuckets;
    buckets.at(bucketNumber)->insertItem(number, terms);
  }
  //returns number of terms for number in sequence
  int searchForItem(long int number){
    int bucketNumber = number % numberOfBuckets;
    return buckets.at(bucketNumber)->searchForItem(number);
  }
  ~HashTable(){
    for(int i = 0; i < numberOfBuckets; i++)
      delete buckets.at(i);
  }
};

long int nextCollatzNumber(long int number);
int insertNumbersToTable(HashTable &table, vector<long int> &numbersNotInTable, long int number);

int main() {
  //hash table (mod 1,000,000)
  HashTable table{1000000};

  //insert base case to hash table: number = 1 then number of terms is 1
  table.insertItem(1, 1);

  long int number;
  vector<long int> numbersNotInTable;

  //go though 2 to 1 000 000 numbers
  for(int n = 2; n < 1000000; n++){
    number = n;
    numbersNotInTable.clear();
    //while number is not in table
    while(table.searchForItem(number) == -1){
      numbersNotInTable.push_back(number);
      number = nextCollatzNumber(number);
    }
    //insert numbers from sequence to table
    if(!numbersNotInTable.empty())
      insertNumbersToTable(table, numbersNotInTable, number);
  }

  //find number with the most terms in sequence in table
  int sequenceNumber = 0 , sequenceNumberTerms = 0, currentNumberOfTerms;
  for(int i = 1; i < 1000000; i++){
    currentNumberOfTerms = table.searchForItem(i);
    if(sequenceNumberTerms < currentNumberOfTerms){
      sequenceNumber = i;
      sequenceNumberTerms = currentNumberOfTerms;
    }
  }
  cout << "Number with longest sequence: " << sequenceNumber << endl;
  cout << "Number of terms in sequence: " << currentNumberOfTerms << endl;

  return 0;
}

long int nextCollatzNumber(long int number){
  if(number % 2 == 0)
    return number / 2;
  else
    return (3 * number + 1);
}

int insertNumbersToTable(HashTable &table, vector<long int> &numbersNotInTable, long int number){
  int terms = table.searchForItem(number);
  int size = numbersNotInTable.size();
  for(int i = 0; i < size; i++)
    table.insertItem(numbersNotInTable.at(size - 1 - i), terms + i + 1);
}