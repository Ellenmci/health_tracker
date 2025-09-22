package utils

object ValidationUtility {
    fun isValidGender(gender: String): Boolean {
        return gender.uppercase() in listOf("F", "M", "O")
    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.+)(\\.)(.+)"
        return Regex(emailRegex).matches(email)
    }

    fun isValidWeight(weight: Double): Boolean {
        return weight > 0 && weight < 500
    }

    fun isValidHeight(height: Float): Boolean {
        return height > 0.3f && height < 3.0f
    }
}