package com.app

import com.app.domain.entities.Film

object MockData {

    val film = Film(
        id = "2 baf70d1 -42 bb -4437 - b551 - e5fed5a87abe",
        title = "Castle in the Sky",
        movie_banner = "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg",
        description = "The orphan Sheeta inherited a mysterious crystal that links her to the mythical" +
                " sky-kingdom of Laputa. With the help of resourceful Pazu and a rollicking band of" +
                " sky pirates, she makes her way to the ruins of the once-great civilization. Sheeta" +
                " and Pazu must outwit the evil Muska, who plans to use Laputa's science to make" +
                " himself ruler of the world.",
        director = "Hayao Miyazaki",
        release_date = "1986",
        running_time = "124",
        url = "https://ghibliapi.vercel.app/films/2baf70d1-42bb-4437-b551-e5fed5a87abe"
    )

    val filmInfoList = listOf(
        Film(
            id = "1",
            title = "title",
            movie_banner = "movieBanner",
            description = "description",
            director = "director",
            release_date = "releaseDate",
            url = "url",
            running_time = "runningTime"
        ),
        Film(
            id = "2",
            title = "title_1",
            movie_banner = "movieBanner_1",
            description = "description_1",
            director = "director_1",
            release_date = "releaseDate_1",
            url = "url_1",
            running_time = "runningTime_1"
        )
    )

    val noInternetConnectionMessage = "Please check your internet connection!"

    val somethingWentWrongMessage = "Something went wrong!"
}

