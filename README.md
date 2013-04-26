Network layer in Android: two different approaches
================================================

This project contains both "naive" and callback-based designs (with its diagrams attached) and implementations of the network layer in an Android project. The goal is to show an easy way to decouple network and UI in order to improve a team's workflow. It allows UI developer to forget about details of network such as user sessions, cached data, etc.

Naive implementation
--------------------

The straightforward solution is to use a bunch of AsyncTask-based classes which will follow those steps:
	
* Performs the HTTP request through another thread and returns the control.
* Other operations are executed.
* Once the response is obtained, it blocks the UI thread again and execute the "onPostExecute" method.

This approach has a lot of disadvantages:

* Interface control and network operations excessively coupled.
* It's hard to hide low-level (network) logic to the view (activities need to know how to process each response).
* Hard implementation of caches.
* It breaks the "Single responsibility principle" (SRP, http://en.wikipedia.org/wiki/SOLID_(object-oriented_design))

Using inheritance we could hide the network logic to the UI programmer but we would still have the "coupling" problem.


Callback-based implementation
---------------------

In this case the idea is to perform a complete decoupling between network and UI. The problem is that the AsyncTask class needs both network (the operation to do in background) and UI logics (operations to do on foreground). Also, it would be necessary to introduce the processing of the data obtained through the network (JSON/XML parsing, DB operations...).

In order to get this design done, I had the following thoughts:

* The MVC pattern: let's treat the network layer like a model which provides us the data.
* Let's wrap the model layer behind a facade (Facade pattern) which wraps the whole model and provides an easy way to use of it.
* Due to the characteristics of the AsyncTask class, we still need the model to know what to do with the operation's response.
* Model (network) operations could receive information regarding to the action to be performed after the request (callback).

This approach solves some all the disadvantages of the first one (however, it might not be worth implementing it in a small project).
