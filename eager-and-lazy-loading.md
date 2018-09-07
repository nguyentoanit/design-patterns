# What is Eager and Lazy loading?

- **Eager loading:** you do everything when asked. Classic example is when you multiply two matrices. You do all the calculations. That's eager loading;
- **Lazy loading:** you only do a calculation when required. In the previous example, you don't do any calculations until you access an element of the result matrix; and
- **Over-eager loading:** this is where you try and anticipate what the user will ask for and preload it.

Let me give you a "Webby" example.

Imagine a page with rollover images like for menu items or navigation. There are three ways the image loading could work on this page:
- Load every single image required before you render the page (eager);
- Load only the displayed images on page load and load the others if/when they are required (lazy); and
- Load only the displayed images on page load. After the page has loaded preload the other images in the background in case you need them (over-eager).


# Eager and Lazy loading database query 
## In Yii
Eager loading executes just one query:

```
$comments = Comment::model()->with('issues')->findAll();
// sql will get all comments with their issues all at once
foreach ($comments as $comment)
{
    $issues = $comment->issues;
    // $comment->issues is already populated
    // you can just access it, no sql needs to be executed at this point
}
```

Lazy loading executes 1 + N queries:

```
$comments = Comment::model()->findAll();
// sql will get all comments, but not with their issues
foreach ($comments as $comment)
{
    $issues = $comment->issues;
    // $comment->issues is not populated at this point
    // so, each comment object has to execute a sql to get related issues here
}
```

## In Laravel
### Eager loading using with()
If we eager load using with(), for example:

```
$users = User::with('comments')->get();
```

if we have 5 users, the following two queries get run immediately:
```
select * from `users`
select * from `comments` where `comments`.`user_id` in (1, 2, 3, 4, 5)
```

### “Lazy” eager loading using load()

# References
- https://stackoverflow.com/questions/1299374/what-is-eager-loading
- https://www.yiiframework.com/forum/index.php/topic/34412-eager-loading-vs-lazy-loading/
- https://laravel.com/docs/5.6/eloquent-relationships#eager-loading
- 