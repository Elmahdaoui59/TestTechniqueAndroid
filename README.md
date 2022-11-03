# TestTechniqueAndroid

I think it's done with the mvvm version.

## Some notes :

the api provides a list of users at the endpoint https://api.github.com/users __
the query {date} doesn't seem to filter any thing. as the documentation https://docs.github.com/en/rest/users/users#list-users doesn't specify any query parameter to filter by date.__
you can also check these two endpoints :__
https://api.github.com/users?q=2004-07-27 __
https://api.github.com/users?q=2019-07-10

They fetch the same list of users as https://api.github.com/users. __
So I haven't seen any reason to include this query.

