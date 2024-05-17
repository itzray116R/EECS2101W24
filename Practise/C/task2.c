int countDigits(int num) {
    int count = 0;
    int originalNum = num;  // Keep the original number for later use

    while (num != 0) {
        num = num / 10;  // Divide num by 10 in each iteration to find the number of digits
        count++;
    }

    // Now, originalNum holds the original number, and count is the number of digits
    if (count == 0) return 0;  // To handle the case when num is 0
    return (originalNum % count);
}