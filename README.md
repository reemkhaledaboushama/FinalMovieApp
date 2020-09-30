This is the final task's submission for the Android Booster (4th) offered by Sprints Co. 
This submission was made by android-booster-team-e consisting of 5 members: 
- Reem Khaled Elsayed worked on Reem's branch
- Ola El-najjar worked on Ola's and Ola2's branches 
- Steven Sameh Refaat worked on Steven's and Steve2 branches
- Yomna Hussein Mohammed worked on Yomna's branch
- Sherif Ahmed Naiem worked on Sherif's branch  


This application requests api from TMDB and displays movies information such as the Movies title, Rating, Release date, and an Overview. 
The application also categorizes movies based on their popularity, and the top-rated ones, and is supposed to include a fragment to save user's favourtie movies. 
This application also supports room, and MVVM architecture such that it allows user to view data previously displayed on screen even when offline
It also supports paging where when one page loads in attached another recycler view below it to support multiple pages

However, we have experienced a couple of issues, regardless of various attempts, we weren't able to make a few things work. For instance,  we failed to understand why paging only works when there is no room support. Thus, for our evaluation's sake we have left the Popular movies category with support of paging, and no room. and vice-versa for the Popular Movies category so that the evaluator can check both scenarios and kindly inform us of what went wrong. 


Furthermore,  we encountered another problem with our favorite s fragment, where we could not post the selected movie to the database that we created, as our response comes in a form of a list. Other than that, we implemented all other neccessary funtions and classes, yet, again,  did not work, therefore, we commented them for the sake of the running of this application.  We kindly ask you to check them as we have exerted a lot of effort in them and we'd be really grateful if you point our mistakes out for us. 


Our Contributions: 
Reem: fragmentes, bottom navigation, movie details, paging and recycler view, like button 

Ola:  Database and room support (for top rated and popular as well as favorites)

Steven: refactoring the code to MVVM ( passing data from the repository to fragments' view models and viewing them from each view model to corresponding
fragemts)


Sherif:  attempt in adding to favorites

Yomna : attempt in adding to favorites 

+ all of us tried to fix the adding to favourites section until last minute (therefore added on the "final" branch)

