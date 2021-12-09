package com.example.homework4

import androidx.annotation.DrawableRes

object PicturesHolder{

    private val pictureNames = arrayOf(
        "Зигмунд Фрейд",
        "Иоганн Себастьян Бах",
        "Владимир Ильич Ленин",
        "Генри Форд",
        "Гомер",
        "Иисус Христос",
        "Адольф Гитлер",
        "Мария Склодовская-Кюри",
        "Стив Джобс",
        "Сьюзен Энтони"
    )
    private val pictureYears = arrayOf(
        "1856—1939",
        "1685—1750",
        "1870—1924",
        "1863—1947",
        "VIII век до н.э.",
        "2 год до н.э.—29",
        "1867—1934",
        "1889—1945",
        "1955—2011",
        "1820—1906"
    )
    private val pictureBio = arrayOf(
        "Основатель психоанализа, который оказал значительное влияние на психологию, медицину, социологию, антропологию, литературу и искусство XX века",
        "Автор более 1000 музыкальных произведений во всех значимых жанрах своего времени (кроме оперы)",
        "Марксист, публицист, идеолог и создатель Третьего (Коммунистического) интернационала, основатель СССР",
        "Промышленник, владелец заводов по производству автомобилей по всему миру, изобретатель. Основоположник фордизма",
        "Древнегреческий поэт-сказитель, которому приписывается создание «Илиады» и «Одиссеи»",
        "В христианстве центральная личность и предсказанный в Ветхом Завете Мессия, ставший искупительной жертвой за грехи людей",
        "Немецкий государственный и политический деятель, основоположник и центральная фигура национал-социализма",
        "Учёная-экспериментатор (физик, химик), первый дважды нобелевская лауреатка в истории",
        "Американский предприниматель, получивший широкое признание в качестве пионера эры IT-технологий",
        "Американская активистка и борец за гражданские права женщин, сыгравшая в XIX веке одну из ключевых ролей в суфражистском движении США"
    )
    private val pictureImages = arrayOf(
        R.drawable.zigmund_circle,
        R.drawable.bach_circle,
        R.drawable.lenin_circle,
        R.drawable.ford_circle,
        R.drawable.homer_circle,
        R.drawable.jesus_circle,
        R.drawable.hitler_circle,
        R.drawable.curie_circle,
        R.drawable.jobs_circle,
        R.drawable.femka_circle
    )
    private val pictureSex = arrayOf(
        "Мужчина",
        "Мужчина",
        "Мужчина",
        "Мужчина",
        "Мужчина",
        "Мужчина",
        "Мужчина",
        "Женщина",
        "Мужчина",
        "Женщина"
    )

    fun createCollectionPictures(): ArrayList<Picture> {
        val pictures: ArrayList<Picture> = ArrayList()
        for (i in 0..9) {
            val picture = Picture(
                pictureNames[i],
                pictureImages[i],
                pictureYears[i],
                pictureBio[i],
                pictureSex[i]
            )
            pictures.add(picture)
        }
        return pictures
    }
}

data class Picture(
    val name: String,
    @DrawableRes val imageDrawableRes: Int,
    val year: String,
    val bio: String,
    val sex: String
)