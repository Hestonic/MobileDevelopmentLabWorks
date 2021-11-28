/*
шаблон Builder (конструктор) упрощает создание объектов.
Таким образом, один и тот же процесс построения может
создавать объекты одного класса с разными свойствами.
 */

/*
Т.к. конструктор приватный - нельзя передать все необходимые строки
в конструктор, т.к. в реальном коде может быть 10 полей,
которые нужно указать в конструктор и такие конструкторы сильно разрастаются.
Билдер решает проблему огромного конструктора, т.к. мы можем по очереди
засетать каждое поле
 */
class House private constructor(
    val foundation: String?,
    val material: String?,
    val roof: String?,
) {

    /*
    Билдер дублирует поля. Все эти значения уже являются VAR, вместо VAL,
    таким образом туда можно запихнуть даже константы.
     */
    data class Builder(
        var foundation: String? = null,
        var material: String? = null,
        var roof: String? = null,
    ){
        fun foundation(foundation: String) = apply { this.foundation = foundation }
        fun material(material: String) = apply { this.material = material }
        fun roof(roof: String) = apply { this.roof = roof }

        fun build() = House(foundation, material, roof)
    }
}
//далее все детали по очереди собираются
//и при помощи итогового метода build() получается готовый дом
fun main() {
    val foodOrder = House.Builder()
        .foundation("Бетон")
        .material("Кирпич")
        .roof("Шифер")
        .build()
}