File  myurlsFile = new File("MyUrls-20230226-usort.txt")
boolean isInitialAppearance = true
String prevTrimLine = ""
String currTrimLine = prevTrimLine
String prevUrl = ""
String currUrl = prevUrl
String prevTime = ""
String currTime = prevTime
Date   prevDate = new Date(0L)
Date   currDate = prevDate
myurlsFile.eachLine { line -> 
  currTrimLine = line.trim()
  // println "line     : $line"
  // println "currTrimLine = currTrimLine"
  if (currTrimLine) {  // skip blank lines
    currUrl = currTrimLine
    currTime = ""
    String[] sa = currTrimLine.split(' ')
    def saSize = sa.size()
    // println "saSize : $saSize"
    if (saSize == 2) {
      // https://www.baeldung.com/groovy-io 20230226.062352
      // https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
      // https://www.baeldung.com/groovy-io Guide to I/O in Groovy
      // https://www.baeldung.com/groovy-io 20230226.221923
      // for now, assume second item in sa, if it exists, is a time string (e.g. 20230226.062352)
      // also for now, assume file was sorted such that, for duplicate URLs, oldest appears first
      currUrl = sa[0]
      currTime = sa[1]
      // should I try to parse a Date instance out of the currTime ???
    }
    if (saSize > 2) {  // for now, ignore this
      // https://www.baeldung.com/groovy-io 20230226.062352
      // https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
      // https://www.baeldung.com/groovy-io Guide to I/O in Groovy
      // https://www.baeldung.com/groovy-io 20230226.221923
    }
    if (!currUrl.equals(prevUrl)) {
      isInitialAppearance = true
      println "currTrimLine : $currTrimLine"
    }
    if (currUrl.equals(prevUrl)) {
      if (isInitialAppearance) {
        // println "prevTrimLine : $prevTrimLine"
      }
      isInitialAppearance = false
    }
    prevTrimLine = currTrimLine
    prevUrl = currUrl
    prevTime = currTime
    prevDate = currDate
  }
}

// File  myurlsFile = new File("MyUrls-20230226-usort.txt")
// boolean isInitialAppearance = true
// String prevTrimLine = ""
// String currTrimLine = prevTrimLine
// String prevUrl = ""
// String currUrl = prevUrl
// String prevTime = ""
// String currTime = prevTime
// Date   prevDate = new Date(0L)
// Date   currDate = prevDate
// myurlsFile.eachLine { line -> 
//   currTrimLine = line.trim()
//   // println "line     : $line"
//   // println "currTrimLine = currTrimLine"
//   if (currTrimLine) {  // skip blank lines
//     currUrl = currTrimLine
//     currTime = ""
//     String[] sa = currTrimLine.split(' ')
//     def saSize = sa.size()
//     // println "saSize : $saSize"
//     if (saSize == 2) {
//       // https://www.baeldung.com/groovy-io 20230226.062352
//       // https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
//       // https://www.baeldung.com/groovy-io Guide to I/O in Groovy
//       // https://www.baeldung.com/groovy-io 20230226.221923
//       // for now, assume second item in sa, if it exists, is a time string (e.g. 20230226.062352)
//       // also for now, assume file was sorted such that, for duplicate URLs, oldest appears first
//       currUrl = sa[0]
//       currTime = sa[1]
//       // should I try to parse a Date instance out of the currTime ???
//     }
//     if (saSize > 2) {  // for now, ignore this
//       // https://www.baeldung.com/groovy-io 20230226.062352
//       // https://www.baeldung.com/groovy-io 20230226.071018 Guide to I/O in Groovy
//       // https://www.baeldung.com/groovy-io Guide to I/O in Groovy
//       // https://www.baeldung.com/groovy-io 20230226.221923
//     }
//     if (!currUrl.equals(prevUrl)) {
//       isInitialAppearance = true
//       println "currTrimLine : $currTrimLine"
//     }
//     if (currUrl.equals(prevUrl)) {
//       if (isInitialAppearance) {
//         // println "prevTrimLine : $prevTrimLine"
//       }
//       isInitialAppearance = false
//     }
//     prevTrimLine = currTrimLine
//     prevUrl = currUrl
//     prevTime = currTime
//     prevDate = currDate
//   }
// }




import java.net.URL;
import java.net.URI;
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    // URL theUrl = new URL("http://company.com/foo.html");
    URL theUrl = null;  // http://www.example.com:1080/docs/resource1.html
    URI theUri = null;  // [scheme:][//authority][path][?query][#fragment]
    System.out.println("theUrl.scheme = " + theUrl.scheme):
    System.out.println("theUrl.authority = " + theUrl.authority):
    System.out.println("theUrl.path = " + theUrl.path):
    System.out.println("theUrl.query = " + theUrl.query):
    System.out.println("theUrl.scheme = " + theUrl.scheme):
  }
}


