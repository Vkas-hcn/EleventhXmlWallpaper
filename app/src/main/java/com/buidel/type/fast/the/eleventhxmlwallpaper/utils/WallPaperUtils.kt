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

}