# TestTechniqueAndroid

I think it's done with the mvvm version.

## Some notes :

the api provides a list of users at the endpoint https://api.github.com/users <br />
the query {date} doesn't seem to filter any thing. as the documentation https://docs.github.com/en/rest/users/users#list-users doesn't specify any query parameter to filter by date.<br />
you can also check these two endpoints :<br />
https://api.github.com/users?q=2004-07-27 <br />
https://api.github.com/users?q=2019-07-10

They fetch the same list of users as https://api.github.com/users. <br />
So I haven't seen any reason to include this query.

![ezgif-1-629a1f054c](https://user-images.githubusercontent.com/107696788/199837438-088546c0-6bd2-4103-887c-f076fc0c1e01.gif)
