# kin QA Challenge
Creating this project certainly had it's difficulties. However, I am happy to say that it's a fully functioning app with a testing stack. I wish I had more time to update the css but it's usable. Here is a video of the app successfully working: https://www.loom.com/share/5367f8145238420cb52a62461a7ce6ae.

The repo includes three separate projects that work together with each other:
- a front end web application created with Vue JS
- a node JS backend
- a testing stack create in Java using Selenium webdriver

---

### to run code
1. clone repo
2. cd into repo folder via terminal
3. run web application via terminal:
    ```
    cd webApp
    npm install
    npm run serve
    ```
4. run api in separate terminal tab (cd in repo folder):
    ```
    cd api
    npm install
    npm run dev
    ```
5. you can now go to the web app via the browser by going to [localhost:8080](http://localhost:8080/)

The initial data is static and any submitted data is stored on a localhost:3080 temporarily. Restarting the api project will delete any submitted data.
 
---

### to run selenium webdriver test
The app is not deployed, so you need to have the web application and api running on your local machine, in order to run the test automation.

1. go to code editor ide (I like esclipse)
2. open test file (located in automation/src/automation/RunTest.java)
3. compile and run file (you will need to install JavaSE-1.8 JRE library in your Build path, see [this article](https://stackoverflow.com/questions/26371055/eclipse-installing-a-new-jre-java-se-8-1-8-0) for assistance)
4. after running the test, an automated Chrome browser window should open and go through common user actions
5. if the Chrome browser window closes by itself, the tests were successfully

The test plan document can be located in automation/testPlan.txt

