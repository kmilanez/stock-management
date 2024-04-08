# Context

You just started your new role as a software engineer at JPMC and you received the task to help implenting the stock management api, a feature people have been waiting for, so it can be exposed via the UI and your team can start promoting it.

The api was implement by someone that is not in the company anymore. and your manager highlited the following issues:

* Whenever money is added to the wallet, the balance is most of the time incorrect.
* Stock converter is adding a value of 3 when the stock does not exist. It should throw an exception instead.
* Conversion after a very big bulk insert (+1 million) takes a look time. 

# Task

* Fix the issues reported by your manager.
* Add more tests to ensure correctness.
* Propose solution to improve the performance of bulk inserts of stocks.