# Mobile Development Laboratory Works

## Home Work 1
**Goal:** get to know the kotlin language
**Task:** Implement the registerUserByPhone and requestAccessCode methods
You can check the correctness of the implementation using a file with the class ExampleUnitTest
**Realization:**
```Kotlin
   fun registerUserByPhone(fullName: String, rawPhone: String): User {
        return User.makeUser(fullName, phone = rawPhone)
            .also { user ->
                if (map.containsKey(user.login)) throw IllegalArgumentException("User already exists")
                if (cleanPhone(rawPhone).matches("^\\+?[0-9]{3}-?[0-9]{6,12}\$".toRegex()))
                    map[user.login] = user
                else throw IllegalArgumentException("Phone is incorrect")
            }
    }
    fun requestAccessCode(login: String) {
        val loginPhone = cleanPhone(login)
        val user = map[loginPhone]

        if (user != null) {
            val accessCode = user.generateAccessCode()
            user.accessCode = accessCode
            user.passwordHash = user.encrypt(accessCode)
            user.sendAccessCodeToUser(login,accessCode)
            map[loginPhone] = user
        }
    }
```

## Home Work 2
**Goal:** to get acquainted with the principles of writing XML code
**task:** develop XML code screen according to the layout in [Figma](https://www.figma.com/file/2sLJOYX5W0NntXMaF0MI5Q/Antonio?node-id=0%3A1). The task is aimed at learning the basics of XML markup 
**Realization:**
![Realization Home Work2](https://sun9-62.userapi.com/impf/mKUS2u1mb1VnuBsj_XrUKU5JJJRh0-ERSj70cw/XyXGTfV427U.jpg?size=720x1560&quality=95&sign=d6521db72f662f8f4abaa0b7cd093b43&type=album)

## Home Work 3
**Goal:** to master the principles of working with fragments
**Task:** Implement a calculator
Displaying 1 activity that contains 2 blocks
1 block - button block
2 block - fragments (always 1 fragment is displayed)

**1 fragment**
when the application starts, the activity with the first fragment is shown
button "1" is displayed in the block of buttons, which refers to the first fragment
in the first fragment there is a message "enter the first number", an editText and a "forward" button
the user enters the first number, presses "forward" and 2 fragment is displayed to him

**2 fragment**
buttons "1" and "2" are displayed in the block of buttons that link to their fragments
in the second snippet there is a message "enter a second number", an editText, a "forward" button and a "back" button
the user enters the second number, presses "forward" and the 3rd fragment is displayed to him
when you press the back button, it jumps to the previous fragment

**3 fragment**
buttons "1", "2" and "3" are displayed in the block of buttons that link to their fragments
in the third snippet there is a message "select a math operation", an editText or a set of buttons with math operations, a "forward" button and a "back" button
the user selects or enters an operation, presses "forward" and 4 fragment is displayed to him
when you press the back button, it jumps to the previous fragment

**4 fragment**
buttons "1", "2", "3", "4" are displayed in the block of buttons that link to their fragments
in the fourth snippet there is a "result" message, a textView (the text consists of an expression and a result) and a back button
when you press the back button, it jumps to the previous fragment

**Top button block**
When clicking on a specific button, the user can immediately get to the fragment associated with the button

Interaction with android back button
If 1 fragment - the application closes
If > 1 fragment - return to the previous fragment

**Realization:**

![Realization Home Work2](https://github.com/Hestonic/MobileDevelopmentLabWorks/blob/main/video/HomeWork3.gif)

## Home Work 4
**Goal:** master the principles of working with RecyclerView
**Task:** It is necessary to finalize homework 3 with [Figma model](https://www.figma.com/file/Y22zyIa4VgtQNXdzCEjV0X/Untitled-Copy-Copy?node-id=0%3A150)
By layout:
Full name (FI) in 1 line
Description 3 lines

You need to implement the screen using:
1) [AppBar (ToolBar)](https://developer.android.com/training/appbar)
2) [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)

For the task, you must select 10 key "personalities" for the history of mankind (in your opinion)
You need to create a list of domain entities (list of data classes) with these personalities
Entity fields:
1) Avatar resource ID (personality pictures). Loading in drawables
2) Full name (FI)
3) Years of life
4) Description of what deserves "respect" (from Wikipedia, the first paragraph)
5) Gender

Next, you need to implement entity substitution in the recyclerView using your Adapter and ViewHolder.
You need to add handlers and display messages using the snackbar:
1) when you click on the card - a message is displayed: "Card pressed: " + name of the "person"
2) when you click on "like" - a message is displayed: "Like clicked: " + name of the "person"

Criteria for evaluation:
1) The design (colors, padding) of the components matches the design on the figma (except for the AppBar, it is standard, it matches)
2) Layout does not move around on different screens (use match_parent/wrap_content)
3) Correctly implemented Adapter/ViewHolder

**Realization:**

![Realization HomeWork4](https://github.com/Hestonic/MobileDevelopmentLabWorks/blob/main/video/HomeWork4.gif)


## Home Work 5
**Goal:** Learn how asyncTask works
**Task:** Create Application:
The user enters the application, he is shown a screen with a list (initially empty). At the time of application startup, an asyncTask is created, which starts "sending" a message every 2 seconds. asyncTask should run for at least 10 seconds (more is better). When a message is received from asyncTask , a new item must be added to the list on the screen. In the cells of the list, the incoming message is displayed

Criteria:
1) asyncTask works correctly
2) The application "survives" the screen flip
3) The progress of the AsyncTask does not disappear during the flip.
**Realization:**

![Realization HomeWork5](https://github.com/Hestonic/MobileDevelopmentLabWorks/blob/main/video/HomeWork5.gif)

## Home Work 6
**Goal:** Apply in practice the knowledge gained as a result of previous homeworks
**Task:** Create data class Node. Based on this class (as a data model for storage), you need to write an application
1 screen:
the node list is displayed. Each element of the list displays the value of its element, and is also colored (default - white). There is a "add" button, by clicking on which screen 2 opens - adding a node
Clicking on a list item opens screen 3 - node detail
painting principle:
if the element is a parent - yellow
if the element is a child - blue
if the element is both parent and child - red

Screen 2 - modal window for adding a node.
There is a value entry field on the screen. Buttons "add", "cancel"

Screen 3 - node detail
The screen displays a list of items. Each element displays a node-to-node relationship (depending on filtering by bottom buttons)
for example "node with value 1 - node with value 2"
the list cannot have a link "node with value x - node with value x". On the screen there are 2 buttons "parents", "children", needed for filtering
when "parents" is pressed, only possible variants of the parent relationship, or existing parent relationships, are displayed. When "children" is pressed, only possible options for a child connection, or existing children's connections, are displayed. Node to node can't be parent and child at the same time, which is obvious, so filtering (display/update) should take this into account
when "parents" is pressed, when clicking on the list item, the parent relationship is added (colored in green). When "children" is pressed, by clicking on an element of the list, a child connection is added (filled in green)

Requirements:
entities (nodes) must be saved / updated / deleted in storage (for example, a database)
the application must survive the screen flip
work with storage should be done asynchronously
**Realization:**

![Realization HomeWork6](https://github.com/Hestonic/MobileDevelopmentLabWorks/blob/main/video/HomeWork6.gif)



