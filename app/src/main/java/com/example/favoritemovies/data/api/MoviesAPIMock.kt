package com.example.favoritemovies.data.api

import com.example.favoritemovies.data.model.Movies
import io.reactivex.Observable

class MoviesAPIMock : MoviesAPI {

    override fun getMoviesList(page: Int): Observable<List<Movies>> {
        return Observable.just(
            listOf(
                Movies().set(
                    "Wonder Woman",
                    2017,
                    "An Amazon princess comes to the world of Man in the grips of the First World War to confront the forces of evil and bring an end to human conflict.",
                    "http://youtube.com/watch?v=1Q8fG0TtVAY",
                    7.69428,
                    listOf("adventure", "superhero", "fantasy", "war")
                ),
                Movies().set(
                    "The Dark Knight",
                    2008,
                    "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
                    "http://youtube.com/watch?v=kmJLuwP3MbY",
                    8.93899,
                    listOf("action", "crime", "drama", "thriller", "superhero")
                ),
                Movies().set(
                    "The Avengers",
                    2012,
                    "When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!",
                    "http://youtube.com/watch?v=eOrNdBpGMv8",
                    8.25446,
                    listOf("action", "adventure", "science-fiction", "superhero")
                ),
                Movies().set(
                    "Deadpool",
                    2016,
                    "Deadpool tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life."
                    ,
                    "http://youtube.com/watch?v=FyKWUTwSYAs",
                    8.30947,
                    listOf("action", "adventure", "comedy", "superhero")
                ),
                Movies().set(
                    "Interstellar",
                    2014,
                    "Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.",
                    "http://youtube.com/watch?v=2LqzF5WauAw",
                    8.47351,
                    listOf("science-fiction", "drama", "adventure")
                ),
                Movies().set(
                    "Inception",
                    2010,
                    "Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: inception, the implantation of another person's idea into a target's subconscious.",
                    "http://youtube.com/watch?v=xitHF0IPJSQ",
                    8.68057,
                    listOf("action", "adventure", "mystery", "science-fiction", "thriller")
                ),
                Movies().set(
                    "Logan",
                    2017,
                    "In the near future, a weary Logan cares for an ailing Professor X in a hideout on the Mexican border. But Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.",
                    "http://youtube.com/watch?v=Div0iP65aZo",
                    7.95731,
                    listOf("action", "science-fiction", "drama", "superhero")
                ),
                Movies().set(
                    "Doctor Strange",
                    2016,
                    "After his career is destroyed, a brilliant but arrogant surgeon gets a new lease on life when a sorcerer takes him under her wing and trains him to defend the world against evil.",
                    "http://youtube.com/watch?v=HSzx-zryEgM",
                    7.84115812542144,
                    listOf("action", "adventure", "science-fiction", "fantasy", "superhero")
                ),
                Movies().set(
                    "Guardians of the Galaxy",
                    2014,
                    "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.",
                    "http://youtube.com/watch?v=b7yOuhI1dzU",
                    8.35894,
                    listOf("adventure", "science-fiction", "action")
                ),
                Movies().set(
                    "Suicide Squad",
                    2016,
                    "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                    "http://youtube.com/watch?v=CmRih_VtVAs",
                    6.79385,
                    listOf("action", "crime", "fantasy", "science-fiction", "superhero", "adventure")
                )
            )
        )
    }
}