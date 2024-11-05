
fun main() {

    val students = mutableListOf(
        Student(mapOf(
            "id" to 1,
            "surname" to "Андреев",
            "name" to "Алексей",
            "patronymic" to "Денисович"
        )),
        Student(mapOf(
            "id" to 2,
            "surname" to "Киреев",
            "name" to "Даниил",
            "patronymic" to "Максимович",
            "phone" to "+78005553535",
            "telegram" to "@danielka666",
            "email" to "danya666@example.com",
            "git" to "https://github.com/dania"
        )),
        Student(mapOf(
            "id" to 3,
            "surname" to "Максюта",
            "name" to "Станислав",
            "patronymic" to "Игоревич",
            "phone" to "+79898229722"

        )),
        Student(mapOf(
            "id" to 4,
            "surname" to "Малаккеев",
            "name" to "Владимир",
            "patronymic" to "Иванович",
            "telegram" to "@volodya",
            "git" to "https://github.com/volodya"
        ))
    )

    students.add(Student(5, "Коваль", "Наталья", "Александровна", "https://github.com/natali",))
    students.add(Student(6, "Фролова", "Анастасия", "Юрьевна",email= "florova@example.com", phone="+79185707868"))


    students.forEach { it.info() }
    students.forEach { it.validate_tg() }
    students.forEach { it.validate_git() }

    students[4].setContacts(mapOf("email" to "staya@example.com"))
    students[4].info()
}

