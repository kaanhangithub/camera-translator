package com.binarystudios.cameratranslator.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TranslateViewModel
@Inject
constructor(

) : ViewModel() {
    val languages = listOf(
        Language("English", "en"),
        Language("Spanish", "es"),
        Language("French", "fr"),
        Language("German", "de"),
        Language("Chinese", "zh"),
        Language("Japanese", "ja"),
        Language("Korean", "ko"),
        Language("Hindi", "hi"),
        Language("Arabic", "ar"),
        Language("Russian", "ru"),
        Language("Portuguese", "pt"),
        Language("Italian", "it"),
        Language("Dutch", "nl"),
        Language("Greek", "el"),
        Language("Turkish", "tr"),
        Language("Swedish", "sv"),
        Language("Norwegian", "no"),
        Language("Danish", "da"),
        Language("Finnish", "fi"),
        Language("Polish", "pl"),
        Language("Czech", "cs"),
        Language("Romanian", "ro"),
        Language("Hungarian", "hu"),
        Language("Thai", "th"),
        Language("Indonesian", "id"),
        Language("Malay", "ms"),
        Language("Vietnamese", "vi"),
        Language("Bengali", "bn"),
        Language("Punjabi", "pa"),
        Language("Telugu", "te"),
        Language("Tamil", "ta"),
        Language("Urdu", "ur"),
        Language("Persian", "fa"),
        Language("Hebrew", "he"),
        Language("Ukrainian", "uk"),
        Language("Swahili", "sw"),
        Language("Filipino", "fil"),
        Language("Amharic", "am")
    )

    var translateFrom  = mutableStateOf(Language("English", "en"))
        private set
    var translateTo = mutableStateOf(Language("Turkish", "tr"))
        private set
    var languageList = mutableStateOf(languages)
        private set
    var translateFromText = mutableStateOf("")
        private set

    fun filterLanguages(query: String) {
        languageList.value = if (query.isEmpty()) {
            languages
        } else {
            languages.filter { it.name.contains(query, ignoreCase = true) }
        }
    }

    fun resetLanguageList() {
        languageList.value = languages
    }

    fun setTranslateFrom(language: Language) {
        translateFrom.value = language
    }

    fun setTranslateTo(language: Language) {
        translateTo.value = language
    }

    fun setTranslateFromText(text: String) {
        translateFromText.value = text
    }

    data class Language (
        val name: String,
        var code: String
    )
}