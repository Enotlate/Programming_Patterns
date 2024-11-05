class Student(
    val id : Int = 0,
    surname : String,
    name: String ,
    patronymic : String,
    phone : String?=null,
    tg : String?=null,
    email : String?=null,
    git : String?=null, )
{

    companion object {
        private val phoneRegex = Regex("""^\+?[0-9]{10,15}$""")
        private val nameRegex = Regex("""^[\p{L}-]+$""")
        private val tgRegex = Regex("""^@\w{5,32}$""")
        private val emailRegex = Regex("""^[A-Za-z0-9_+-]+(\.[A-Za-z0-9_+-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9-]+)+$""")
        private val gitRegex = Regex("""^(https?://)?([A-Za-z0-9]+\.)?[A-Za-z0-9]+\.[A-Za-z0-9]+/[A-Za-z0-9_-]+/?$""")

        fun isValidName(value: String) = nameRegex.matches(value)
        fun isValidPatronymic(value: String) = value.isEmpty() || isValidName(value)
        fun isValidPhoneNumber(value: String?) = value == null || phoneRegex.matches(value)
        fun isValidTelegram(value: String?) = value == null || tgRegex.matches(value)
        fun isValidEmail(value: String?) = value == null || emailRegex.matches(value)
        fun isValidGit(value: String?) = value == null || gitRegex.matches(value)
    }

    constructor(id: Int,
                surname: String,
                name: String,
                patronymic: String,
                git: String) : this(id, surname, name, patronymic) {
        this.git = git
        println("Второй конструктор для гита")
    }
    constructor(id: Int,
                surname: String,
                name: String,
                patronymic: String,
                email: String,
                phone: String) : this(id, surname, name, patronymic) {
        this.email = email
        this.phone = phone
        println("Второй конструктор для почты и телефона")
    }

    var surname = surname
        get() = field
        set(value) {
            if (isValidName(value)) field = value
            else throw IllegalArgumentException("Фамилия имеет недопустимое значение")
        }
    var name = name
        get() = field
        set(value) {
            if (isValidName(value)) field = value
            else throw IllegalArgumentException("Имя имеет недопустимое значение")
        }
    var patronymic = patronymic
        get() = field
        set(value) {
            if (isValidPatronymic(value)) field = value
            else throw IllegalArgumentException("Отчество имеет недопустимое значение")
        }
    var phone = phone
        get() = field
        set(value) {
            if (isValidPhoneNumber(value)) field = value
            else throw IllegalArgumentException("Номер телефона имеет недопустимое значение")
        }
    var tg = tg
        get() = field
        set(value) {
            if (isValidTelegram(value)) field = value
            else throw IllegalArgumentException("Имя пользователя Telegram имеет недопустимое значение")
        }
    var email = email
        get() = field
        set(value) {
            if (isValidEmail(value)) field = value
            else throw IllegalArgumentException("Адрес электронной почты имеет недопустимое значение")
        }
    var git = git
        get() = field
        set(value) {
            if (isValidGit(value)) field = value
            else throw IllegalArgumentException("Ссылка на Git имеет недопустимое значение")
        }

    override fun toString(): String {
        var str = "[ID $id] $surname $name $patronymic"
        if (phone != null) str += "\nНомер телефона: $phone"
        if (tg != null) str += "\nTelegram: $tg"
        if (email != null) str += "\nEmail: $email"
        if (git != null) str += "\nGit: $git"
        return "$str\n"
    }

    fun info()= println(this.toString())

    constructor(hashMap: Map<String, Any>) : this(
        hashMap["id"]       as  Int,
        hashMap["surname"]  as  String,
        hashMap["name"]     as  String,
        hashMap["patronymic"] as  String,
        hashMap["phone"]    as? String,
        hashMap["telegram"] as? String,
        hashMap["email"]    as? String,
        hashMap["git"]      as? String,
    )
    {
        println("Конструктор хэш-карты")
    }

    fun validate_git(): Boolean{
        var res=false
        if (git!=null){
            res=true
            println("У студента $id гит есть")
        }
        else println("У студента $id гита нет")
        return res
    }
    fun validate_tg(): Boolean{
        var res=false
        if (tg!=null){
            res=true
            println("У студента $id телеграм есть")
        }
        else println("У студента $id телеграм нет")
        return res
    }

    fun setContacts(hashMap: Map<String, String?>) {
        if (hashMap.containsKey("phone")) phone = hashMap["phone"]
        if (hashMap.containsKey("telegram")) tg = hashMap["telegram"]
        if (hashMap.containsKey("email")) email = hashMap["email"]
    }

}