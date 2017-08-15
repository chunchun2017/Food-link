# Food-link

This code is to get food's image's URL
First User Agent request header contains a characteristic string that allows network protocol peers to identifty the application type, operating system, software vendor and the software version of the requesting software user agent.

In HTTP, SIP, and NNTP protocols, this identification is transmitted in a header field called User-Agent.

Mozilla/5.0 is the general token that shows the browser is Mozilla compatible, which is common to almost every browser today.

To know more about User agent and Mobillza 5.0. Please check out the link below,

https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/User-Agent, https://en.wikipedia.org/wiki/User_agent



First to build an Arraylist to collect food's names from "foodlist.txt" and then to loop the data collecting process.

Use the collected food's name to create URL, then use URL to get JSONObject.

Printwriter will sends each JSONObject to the file("food.txt").

Everytime after Printwriter sending a new JSONObject to the text file, the old one will be replaced by new one. So after the code finished running only the most updated JSONObject will be preserved.

At last, use Bufferedreader and Filereader to read it one by one. 

JSONObject contains a lot of information of the URL you created. You can get the link out of the item from JSONObject.