"""
n! means n × (n − 1) × ... × 3 × 2 × 1
For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
Find the sum of the digits in the number 100!
"""
def getRemainder(factorial, remainder, number, index):
    result = (int(factorial[index]) * number) + remainder
    validDigit = result % 10
    factorial[index] = validDigit
    remainder = int(result / 10)
    return remainder

def adjustMaxIndex(remainder, factorial, maxIndex):
    increaseIndex = 0
    while remainder != 0:
        validDigit = int(remainder % 10)
        factorial.append(validDigit)
        remainder = int(remainder / 10)
        increaseIndex += 1
    maxIndex += increaseIndex
    return maxIndex

factorial = [1]
maxIndex = 0
remainder = 0
# loop through numbers in factorial
for number in range(1, 100):
    for index in range(0, maxIndex + 1):
        remainder = getRemainder(factorial, remainder, number, index)
    maxIndex = adjustMaxIndex(remainder, factorial, maxIndex)
    remainder = 0

#print result
sum = 0
for number in factorial:
    sum += number
print(sum)