# def isPalindrome(x):
#     # Check for negative numbers and single-digit numbers
#     if x < 0 or (x % 10 == 0 and x != 0):
#         return False

#     reversed_number = 0
#     original_number = x

#     # Reverse the digits of the number
#     while x > 0:
#         digit = x % 10
#         reversed_number = reversed_number * 10 + digit
#         x = x // 10

#     # Compare the reversed number with the original number
#     return original_number == reversed_number

# # Test cases
# print(isPalindrome(121)) # Output: True
# print(isPalindrome(-121)) # Output: False
# print(isPalindrome(10))   # Output: False
# print(isPalindrome(0))
# print(isPalindrome(130))
# print(isPalindrome(101))
# print(isPalindrome(1))

# def isPalindrome(x):
#     # Negative numbers are not palindromes
#     if x < 0:
#         return False

#     # Initialize reversed half and the remaining part of x
#     reversed_half = 0
#     remaining = x

#     while remaining > reversed_half:
#         # Take the last digit from remaining and add it to reversed_half
#         reversed_half = reversed_half * 10 + remaining % 10
#         # Remove the last digit from remaining
#         remaining //= 10

#     # Check if the first half and the reversed second half are equal
#     # For odd number of digits, we can ignore the middle digit by dividing reversed_half by 10
#     return remaining == reversed_half or remaining == reversed_half // 10

# # Test cases
# print(isPalindrome(121))  # Output: True
# print(isPalindrome(-121))  # Output: False
# print(isPalindrome(10))   # Output: False

# def isPalindrome(x):
#     # Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
#     if x < 0 or (x % 10 == 0 and x != 0):
#         return False

#     reversed_half = 0
#     # Build the reverse of the second half of x
#     while x > reversed_half:
#         reversed_half = reversed_half * 10 + x % 10
#         x //= 10

#     # When the length of the number is odd, we can get rid of the middle digit by reversed_half // 10
#     return x == reversed_half or x == reversed_half // 10
def isPalindrome(x):
    # Negative numbers are not palindromes
    if x < 0:
        return False
    original = x
    reversed_num = 0

    # Reverse the number
    while x > 0:
        digit = x % 10 # Get the last digit
        reversed_num = reversed_num * 10 + digit # Append the digit to the reversed number
        x //= 10 # Remove the last digit from x

    # Check if the original number is equal to the reversed number
    return original == reversed_num


# Test cases
print(isPalindrome(121))  # Output: True
print(isPalindrome(-121))  # Output: False
print(isPalindrome(10))   # Output: False
print(isPalindrome(0))   # Output: True
print(isPalindrome(130)) # Output: False
print(isPalindrome(101)) # Output: True
print(isPalindrome(1))  # Output: True