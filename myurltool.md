On my iPad I created an iOS shortcut (which I need to document) that that I can use
in a browser to send the current URL to a note (named MtUrls) and which appends the 
current date and time (as yyyymmdd.hhmmss) to the URL string. When the MyUrls note
starts to get large, the performance of the shortcut starts to degrade.  When that
happens, I rename the MyUrls note (to something like MyUrls-20230226), and then
I create a new MyUrls note.  Also note that because of the way I have written the
shortcut, there are blank lines between the URL strings within the MyUrls note

In order to get the maximum value from the collection of MyUrls notes, I would like
to be able do several things.

Write a script (probably in Mac OS on my Mac Mini M2) to locate the MyUrls notes
in iCloud and copy each note to a corresponding file in the Mac OS file sysetem.
Perhaps I will write the script to create files named something like MyUrls-20230226-raw.txt

I will used "sed" to remove all blank lines and "sort" to order the URL strings within
the file alphabetically (creating MyUrls-20230226-usort.txt).  While I will use the -u
option on the sort, it will not eliminate "duplicate URL strings" if I visited and saved
the same URL multiple times (because of the date & time appended to the URL string)

sed -e "/^$/d" MyUrls-20230226-raw.txt | sort -u > MyUrls-20230226-usort.txt

https://www.baeldung.com/groovy-io 20230226.062352
https://www.baeldung.com/groovy-io 20230226.071018
https://www.baeldung.com/groovy-io 20230226.185503

I want to write code (probably in Groovy at first) to read each text file and eliminate
the duplicate URL strings. I intend to retain only the first (chronologically) string.
However, if I have annotated one of the strings, I will prioritize that URL string
instead of prioritizing based on the earliest date.

https://www.baeldung.com/groovy-io 20230226.062352
https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
https://www.baeldung.com/groovy-io 20230226.185503

It is also possible that I will have created a file containing URL strings using
something other than the iOS shortcut.  I hope that I will have put a date inside
that file that I can use to append the yyyymmdd.hhmmss to each URL string in the file.

It would also be helpful if I could group the URLs by topics. For instance, I would be
great to have a group of all "Apple related" URLs together.

Sun Feb 26 07:52:21 AM EST 2023
http://docs.groovy-lang.org/docs/groovy-1.7.3/html/groovy-jdk/java/io/File.html
https://blog.mrhaki.com/2009/08/groovy-goodness-working-with-files.html
https://docs.groovy-lang.org/latest/html/groovy-jdk/java/io/File.html
https://opensource.com/article/21/4/groovy-io
https://www.baeldung.com/groovy-io
https://www.baeldung.com/reading-file-in-java
https://www.tutorialspoint.com/groovy/groovy_file_io.htm
https://groovy-lang.org/groovyconsole.html
https://www.tutorialspoint.com/groovy/groovy_split.htm

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
/home/davidho/myurltool/MyUrls-20230226-raw.txt

https://www.baeldung.com/reading-file-in-java 20230226.084512

https://www.baeldung.com/reading-file-in-java 20230226.084555

https://www.baeldung.com/reading-file-in-java 20230226.230205

https://www.baeldung.com/groovy-io 20230226.062352

https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy

https://www.baeldung.com/groovy-io 20230226.185503

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
/home/davidho/myurltool/MyUrls-20230226-usort.txt

https://www.baeldung.com/groovy-io 20230226.062352
https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
https://www.baeldung.com/groovy-io 20230226.185503
https://www.baeldung.com/reading-file-in-java 20230226.084512
https://www.baeldung.com/reading-file-in-java 20230226.084555
https://www.baeldung.com/reading-file-in-java 20230226.230205

File  myurlsFile = new File("MyUrls-20230226-usort.txt")
myurlsFile.eachLine {  line -> 
  println "line : $line"
}

groovy> File  myurlsFile = new File("MyUrls-20230226-usort.txt") 
groovy> myurlsFile.eachLine {  line ->  
groovy>   println "line : $line" 
groovy> } 
 
line : https://www.baeldung.com/groovy-io 20230226.062352
line : https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
line : https://www.baeldung.com/groovy-io 20230226.185503
line : https://www.baeldung.com/reading-file-in-java 20230226.084512
line : https://www.baeldung.com/reading-file-in-java 20230226.084555
line : https://www.baeldung.com/reading-file-in-java 20230226.230205

File  myurlsFile = new File("MyUrls-20230226-usort.txt")
def prevUrl = ""
def currUrl = ""
myurlsFile.eachLine {  line -> 
def trimLine = line.trim()
  println "line     : $line"
  println "trimLine : $trimLine"
  String[] sa = trimLine.split(' ')
  def saSize = sa.size()
  println "saSize : $saSize"
  if (saSize < 2) {
    currUrl = trimLine
  } else {
    currUrl = sa[0]
  }
  if (!currUrl.equals(prevURL)) {
      println "currUrl : $currUrl"
  }
}

groovy> File  myurlsFile = new File("MyUrls-20230226-usort.txt") 
groovy> def prevUrl = "" 
groovy> def currUrl = "" 
groovy> myurlsFile.eachLine {  line ->  
groovy> def trimLine = line.trim() 
groovy>   println "line     : $line" 
groovy>   println "trimLine : $trimLine" 
groovy>   String[] sa = trimLine.split(' ') 
groovy>   def saSize = sa.size() 
groovy>   println "  saSize : $saSize" 
groovy>   if (saSize < 2) { 
groovy>     currUrl = trimLine 
groovy>   } else { 
groovy>     currUrl = sa[0] 
groovy>   } 
groovy>   println "  currUrl : $currUrl" 
groovy> } 
 
line     : https://www.baeldung.com/groovy-io 20230226.062352
trimLine : https://www.baeldung.com/groovy-io 20230226.062352
  saSize : 2
  currUrl : https://www.baeldung.com/groovy-io
line     : https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
trimLine : https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
  saSize : 7
  currUrl : https://www.baeldung.com/groovy-io
line     : https://www.baeldung.com/groovy-io 20230226.185503
trimLine : https://www.baeldung.com/groovy-io 20230226.185503
  saSize : 2
  currUrl : https://www.baeldung.com/groovy-io
line     : https://www.baeldung.com/reading-file-in-java 20230226.084512
trimLine : https://www.baeldung.com/reading-file-in-java 20230226.084512
  saSize : 2
  currUrl : https://www.baeldung.com/reading-file-in-java
line     : https://www.baeldung.com/reading-file-in-java 20230226.084555
trimLine : https://www.baeldung.com/reading-file-in-java 20230226.084555
  saSize : 2
  currUrl : https://www.baeldung.com/reading-file-in-java
line     : https://www.baeldung.com/reading-file-in-java 20230226.230205
trimLine : https://www.baeldung.com/reading-file-in-java 20230226.230205
  saSize : 2
  currUrl : https://www.baeldung.com/reading-file-in-java
