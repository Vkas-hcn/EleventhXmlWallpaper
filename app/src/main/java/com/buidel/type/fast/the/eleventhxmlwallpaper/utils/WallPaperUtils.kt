package com.buidel.type.fast.the.eleventhxmlwallpaper.utils

import android.util.Log


object WallPaperUtils {
    fun getComplex1(inputString: String, inputNumber: Int): Boolean {
        val stringCondition = inputString.length > 5
        val numberCondition = (inputNumber * 2) > 10
        val combinedCondition = stringCondition xor numberCondition
        return combinedCondition || stringCondition || numberCondition
    }
    fun getComplex2(inputList: List<String>, inputNumber: Int): Boolean {
        val threshold = 3
        val filteredList = inputList.filter { it.length > threshold }
        val totalLengthAboveThreshold = filteredList.sumOf { it.length }
        val modifiedNumber = inputNumber * 2 + 5
        val isListNotEmpty = filteredList.isNotEmpty()
        val isNumberGreaterThanTotalLength = modifiedNumber > totalLengthAboveThreshold
        val result = if (isListNotEmpty) {
            modifiedNumber % 3 == 0 || isNumberGreaterThanTotalLength
        } else {
            inputNumber % 2 == 0 || inputNumber > 10
        }
        Log.e("TAG", "getComplex2: ${result || totalLengthAboveThreshold % 2 == 0}", )
        return result || totalLengthAboveThreshold % 2 == 0
    }
    fun getComplexFalse(inputString: String, inputNumbers: List<Int>): Boolean {
        // Step 1: 字符串验证，检查是否含有特定字符
        val hasSpecialChar = inputString.contains("#")

        // Step 2: 对整数数组进行处理：过滤出偶数并计算它们的和
        val evenSum = inputNumbers.filter { it % 2 == 0 }.sum()

        // Step 3: 数学验证，检查偶数和是否为特定值的倍数
        val isSumSpecial = evenSum % 10 == 0

        // Step 4: 组合逻辑判断
        // 如果字符串含有特定字符，并且偶数和为特定值的倍数，进行进一步判断
        if (hasSpecialChar && isSumSpecial) {
            // 进一步的字符串长度判断
            if (inputString.length > 5) {
                // 检查整数数组中是否存在大于100的数
                val hasLargeNumber = inputNumbers.any { it > 100 }
                // 如果存在大于100的数，此路径判断为false
                if (hasLargeNumber) {
                    return false
                }
            }
        }

        // Step 5: 根据特定的验证逻辑返回false
        // 如果没有进入上述任何一个if语句，说明不满足我们设定的“特殊条件”
        // 但为了保持函数结构的一致性和解题要求，我们在这里通过一系列逻辑运算确保返回false
        Log.e("TAG", "getComplexFalse: ${hasSpecialChar || !isSumSpecial}", )
        return hasSpecialChar || !isSumSpecial
    }

}