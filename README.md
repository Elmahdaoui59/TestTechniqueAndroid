# TestTechniqueAndroid

I think it's done with the mvvm version.

##Some notes
the api provides a list of users at the endpoint https://api.github.com/users
the query date doesn't seem to filter any thing. as the documentation https://docs.github.com/en/rest/users/users#list-users doesn't specify any query parameter to filter by date.
also you can check these two endpoints :
https://api.github.com/users?q=2004-07-27
https://api.github.com/users?q=2019-07-10

They fetch the same list of users as https://api.github.com/users.
So I haven't seen any reason to include this query.

