# The Dstillery MiniBidder

The MiniBidder is a simplified example of how we buy ads on a real-time 
bidding (RTB) exchange. The problems below are downscaled versions of actual 
issues we deal with, so working through them should let you see if some of 
the problems we have are ones you're interested in solving.

Please select any 2 of the problems below to complete. Each one should take 
you about an hour or so, but there's no time limit or due date. We don't have 
any preference among them, so pick the ones that you find most interesting or 
that you feel you could do most successfully. 

Commit each completed problem on the master branch with a comment in the 
format of "completed #n", so that you end up making only 2 total commits on 
the master branch (if you like making smaller commits, use branches and keep 
master reserved for your completed work). Please do not submit more than 2 
problems. This speeds up our review and lets us get a response to you sooner.

When you've finished all your problems, package up your repository using 
[`git bundle`](http://git-scm.com/blog/2010/03/10/bundles.html).  This should
be a whole-repository bundle, not just your commits.  Submit your work via 
email to [minibidder@dstillery.com](mailto:minibidder@dstillery.com). You can 
send any questions you might have to this address, as well.

# What We're Looking For

A good solution will first and foremost be *correct*.  Please make sure that 
your answers are threadsafe, accurate, and satisfy the described constraints.

Aside from correctness, we're interested in proper design.  Where it makes 
sense, your code should take advantage of the MiniBidder's existing structure.

And finally, efficiency counts. You don't need to spend a lot of time on 
serious optimization work, but you should generally be mindful of how fast 
your code will run and how much memory it will consume, especially under load.

Tests are welcome and encouraged but are not strictly required. You won't be 
penalized for skipping them if your answers are otherwise correct, but we 
don't like seeing issues that a test could have easily caught.


# The Problems

1. We run a lot of experiments, and we need to be able to randomly sample our 
cookie population to feed data to those experiments. For instance, a given 
experiment might need a sample of 5% of our cookies in order to collect enough 
data to give us a meaningful result. We have two constraints on this sampling: 

    - A given experiment's cookie population must be *stable*, that is,
      a given cookie is always in or out of a given experiment's sample 
      population.
    - Different experiments must have *different populations*. They don't have 
      to be disjoint, but any overlap between populations must be purely by 
      chance. 
     
    Extend the bidder so that it can tag each bid request with the experiment 
    populations it belongs to. As the focus of this task is on correctly 
    implementing the random sampling so that the two given constraints are met, 
    the tagging functionality is already stubbed out in the bidder for you, in
    the `ExperimentTagBRQFilter` class.

2. Our Data Science team has figured out that the relationship between the 
time of day and how much we need to adjust our bid in order to win can be 
described by a parabola.  Implement the following bid strategy, where *d* 
indicates the default bid price and *t* indicates the hours elapsed since 11am:

    - From 11am to 2am, bid *d* * 1.07^(7-((1/7) * (*t*-7)^2))
    - Any other time, just bid *d*. 
    - Examples, *d* = 200:
        - 12:36pm -> *t* = 1.6, bid = 242
        - 4:17pm -> *t* = 5.2833, bid = 312
        - 1:55am -> *t* = 14.9167, bid = 175 
          
3. There's currently no way to see what a running MiniBidder is up to. Use the
[metrics](https://dropwizard.github.io/metrics) library to add monitoring for
at least 3 questions you think we need to be able to answer about a running
bidder to ensure everything's running smoothly. As an example to get you
started: how many bid requests are we receiving? 

4. We've noticed an issue where, when two or more campaigns have the same 
ad size, base bid price, and bid strategy, we always bid for one but not the 
others. Figure out why the bidder is doing this and fix it so that we randomly 
select from the qualifying tied campaigns. 




One last note:  we don't provide a client, but you can easily make a request
to a locally-running instance of the bidder using `curl`, like so:

    curl http://localhost:4567/ex/ads-r-us -H "Content-Type: application/json" -X POST -d '{ "publisher": "pub", "cookie": "12345", "size":"300x250" }' -w "\n"

     
 
     
