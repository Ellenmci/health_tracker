import models.User
import utils.ValidationUtility

var user = User()

fun main(){
    println("Welcome to Health Tracker")
    runApp()
}

fun menu(): Int{
    print("""Main Menu:
        1. Add User
        2. List User
        0. Exit
        Please enter your option: """.trimMargin())
    return readlnOrNull()?.toIntOrNull() ?: -1
}

fun runApp(){
    var input: Int
    do {
        input = menu()
        when(input) {
            1 -> addUser()
            2 -> listUser()
            in(3..6) -> println("Feature coming soon")
            0 -> println("Bye...")
            else -> print("Invalid Option")
        }
    } while (input != 0)
}
fun addUser() {
    println("Please enter the following for the user:")
    print("    Name: ")
    user.name = readln()

    print("    Email: ")
    val emailInput = readln()
    if (ValidationUtility.isValidEmail(emailInput)) {
        user.email = emailInput
    } else {
        println("    Invalid email format. Keeping default email: ${user.email}")
    }

    print("    Id: ")
    user.id = readlnOrNull()?.toIntOrNull() ?: -1

    print("    Weight (kg): ")
    val weightInput = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    if (ValidationUtility.isValidWeight(weightInput)) {
        user.weight = weightInput
    } else {
        println("    Invalid weight entered. Using default weight: ${user.weight}")
    }

    print("    Height (m): ")
    val heightInput = readlnOrNull()?.toFloatOrNull() ?: 0.0f
    if (ValidationUtility.isValidHeight(heightInput)) {
        user.height = heightInput
    } else {
        println("    Invalid height entered. Using default height: ${user.height}")
    }

    var genderInput: String
    do {
        print("    Gender (F/M/O): ")
        genderInput = readln().trim().uppercase()
        if (!ValidationUtility.isValidGender(genderInput)) {
            println("    Invalid gender. Please enter F, M, or O.")
        }
    } while (!ValidationUtility.isValidGender(genderInput))
    user.gender = genderInput.first()
}


fun listUser(){
    print("The user details are: $user")
}