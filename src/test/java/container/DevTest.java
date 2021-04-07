package container;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DevTest {
    public static int returnRandom(){

        int max = 6;
        int min = 1;
        return   max - min + 1;
    }


    public static String generateName(){



        String [] firstNames =   { "Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter", "Kr", "Ca", "Ra", "Mrok", "Cru",  "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
                "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",  "Mar", "Luk","air", "ir", "mi", "sor", "mee", "clo",
                "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
                "marac", "zoir", "slamar", "salmar", "urak","d", "ed", "ark", "arc", "es", "er", "der",
                "tron", "med", "ure", "zur", "cred", "mur","Harry","Ross",
                "Bruce","Cook",
                "Carolyn","Morgan",
                "Albert","Walker",
                "Randy","Reed",
                "Larry","Barnes",
                "Lois","Wilson",
                "Jesse","Campbell",
                "Ernest","Rogers",
                "Theresa","Patterson",
                "Henry","Simmons",
                "Michelle","Perry",
                "Frank","Butler",
                "Shirley", "Rachel","Edwards",
                "Christopher","Perez",
                "Thomas","Baker",
                "Sara","Moore",
                "Chris","Bailey",
                "Roger","Johnson",
                "Marilyn","Thompson",
                "Anthony","Evans",
                "Julie","Hall",
                "Paula","Phillips",
                "Annie","Hernandez",
                "Dorothy","Murphy",
                "Alice","Howard", "Debra","Allen",
                "Gerald","Harris",
                "Raymond","Carter",
                "Jacqueline","Torres",
                "Joseph","Nelson",
                "Carlos","Sanchez",
                "Ralph","Clark",
                "Jean","Alexander",
                "Stephen","Roberts",
                "Eric","Long",
                "Amanda","Scott",
                "Teresa","Diaz",
                "Wanda","Thomas" };

        String[] lastNames = new String[] { "Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler" };
        Random rand = new Random();
        String rFirst = firstNames[rand.nextInt(165)];
        String rLast = lastNames[rand.nextInt(147)];
        return rFirst +" =  "+ rLast;
    }
    WebDriver driver = null;

    @BeforeMethod
    public void beforeTest(){
       System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
       driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      // driver.get("https://demo.nextvote.com/#/passport/login");
       driver.get("https://demo.nextvote.com/#/passport/login");
        driver.findElement(By.id("txtUserName")).clear();
        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
        driver.findElement(By.xpath("//div/div")).click();
        driver.findElement(By.xpath("//button[@id='btnLogin']/div")).click();
        driver.findElement(By.xpath("//button[@id='btnChenango']/div")).click();

    }



    @Test
    public void createUniqueRandomVoter() throws InterruptedException {

        String fullName = generateName();
        String fN = fullName.substring(0, fullName.indexOf("="));
        String lN = fullName.substring(fullName.indexOf("=") + 1);
        System.out.println("First name::    " + fN + " last name:: " + lN);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement voterModule = driver.findElement(By.id("Function_Voters"));
        wait.until(ExpectedConditions.elementToBeClickable(voterModule)).click();
        WebElement voterMgmt = driver.findElement(By.xpath("//span[contains(text(),'Voter Management')]"));
        wait.until(ExpectedConditions.elementToBeClickable(voterMgmt)).click();
        WebElement newHover = driver.findElement(By.xpath("//span[text()=' New ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(newHover).perform();
        WebElement newBtn = driver.findElement(By.cssSelector("li#ddlBtn_new > a"));
        wait.until(ExpectedConditions.elementToBeClickable(newBtn)).click();
        String firstName = fN;
        String lastName = lN;
        WebElement lName = driver.findElement(By.id("txtLastName"));
        lName.sendKeys(lastName);
        WebElement fName = driver.findElement(By.id("txtFirstName"));
        fName.clear();
        fName.sendKeys(firstName);
        WebElement confirmBtn = driver.findElement(By.id("btn_popup1_ok"));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
        driver.findElement(By.id("Function_Voters_WorkItems")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("th#table1_ID  .ant-table-column-sorters")).click();
        Thread.sleep(3000);
        WebElement row1 = driver.findElement(By.id("btn_table1_row1"));
        row1.click();
        driver.findElement(By.cssSelector("button#btnFalsePositive > div")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        WebElement vMgmtBtn = driver.findElement(By.xpath("//span[contains(text(),'Voter Management')]"));
        vMgmtBtn.click();
        driver.findElement(By.xpath("//div[@id='maincontent']/section[@class='alain-default__content']/app-voter-management[@class='ng-star-inserted']//app-list-page//span[.='Show Only Active']")).click();
        WebElement fiName = driver.findElement(By.id("txtSearchFirstName"));
        wait.until(ExpectedConditions.visibilityOf(fiName));
        fiName.sendKeys(fN);
        WebElement laName = driver.findElement(By.id("txtSearchLastName"));
        wait.until(ExpectedConditions.visibilityOf(laName));
        laName.sendKeys(lN);
        WebElement srchBtn = driver.findElement(By.id("btnSearch"));
        srchBtn.click();
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
        WebElement r1 = driver.findElement(By.id("btn_table1_row1"));
        r1.click();
        WebElement editBtn = driver.findElement(By.id("btn_tab1_section1_edit"));
        editBtn.click();
        js.executeScript("window.scrollBy(0,600)");
        //driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
        WebElement statusField = driver.findElement(By.cssSelector("nz-select#ddlVoterStatus  .ant-select-selection__rendered"));
//        statusField.click();
        String statusTxt = statusField.getText();
        System.out.println("statusTxt = " + statusTxt);
        if (statusTxt.equalsIgnoreCase("active")) {

            WebElement voterStsRsn = driver.findElement(By.xpath("// nz-select[@id='ddlVoterStatusReason']"));
            Thread.sleep(1000);

            actions.moveToElement(voterStsRsn).click().build().perform();
//            voterStsRsn.click();
            int ran = returnRandom();
            String con = Integer.toString(ran);
            WebElement dropdownValue = driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(6)"));
            wait.until(ExpectedConditions.elementToBeClickable(dropdownValue)).click();
            Thread.sleep(1000);

            //WebElement reasonDropdown1 = driver.findElement(By.cssSelector("nz-select#ddlVoterStatus  .ant-select-selection__rendered"));
            statusField.click();
            WebElement inActiveOption = driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(3)"));
            inActiveOption.click();
//            driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(3)")).click();
//            Thread.sleep(3000);
            WebElement sveBtn = driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(1000);

        } else {
            WebElement reasonDropdown2 = driver.findElement(By.cssSelector("nz-select#ddlVoterStatus  .ant-select-selection__rendered"));
            reasonDropdown2.click();
            WebElement activeOption = driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(1)"));
            activeOption.click();
//            driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(3)")).click();
//            Thread.sleep(3000);
            WebElement sveBtn = driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(1000);


        }

    }


//    @Test
//    public void voterQuickLookUp() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        driver.findElement(By.id("txtFirstName")).click();
//        driver.findElement(By.id("txtFirstName")).clear();
//        String firstName = "Mary";
//        String lastName = "Marchese";
//        driver.findElement(By.id("txtFirstName")).sendKeys(firstName);
//        WebElement lNameField =  driver.findElement(By.xpath("//label[@id='lblLastName'] //parent::div//following-sibling::div//input"));
//        wait.until(ExpectedConditions.visibilityOf(lNameField)).sendKeys(lastName);
//        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
//        WebElement expectedFName=driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[2]"));
//        WebElement expectedLName = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
//        wait.until(ExpectedConditions.visibilityOf(expectedFName));
//        wait.until(ExpectedConditions.visibilityOf(expectedLName));
//        Assert.assertEquals(firstName.toLowerCase(), expectedFName.getText().toLowerCase());
//        Assert.assertEquals(lastName.toLowerCase(), expectedLName.getText().toLowerCase());
//
//
//
//
//
//
//    }

    //    @Test
//            public void test5(){
//        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//        driver.get("https://demo.nextvote.com/#/passport/login");
//        driver.findElement(By.id("txtUserName")).clear();
//        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
//        driver.findElement(By.id("txtPassword")).clear();
//        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
//        driver.findElement(By.xpath("//div/div")).click();
//        driver.findElement(By.xpath("//button[@id='btnLogin']/div")).click();
//        driver.findElement(By.xpath("//button[@id='btnChenango']/div")).click();
//
//
//
//    }
    @Test
    public void quickSrcByName(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.id("txtFirstName")).click();
        driver.findElement(By.id("txtFirstName")).clear();
        String firstName = "Mary";
        String lastName = "Marchese";
        driver.findElement(By.id("txtFirstName")).sendKeys(firstName);
        WebElement lNameField =  driver.findElement(By.xpath("//label[@id='lblLastName'] //parent::div//following-sibling::div//input"));
        wait.until(ExpectedConditions.visibilityOf(lNameField)).sendKeys(lastName);
        WebElement scBtn =  driver.findElement(By.xpath("//button[@id='btnSearch']/div"));
        wait.until(ExpectedConditions.visibilityOf(scBtn)).click();
        WebElement expectedFName=driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[2]"));
        WebElement expectedLName = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
        wait.until(ExpectedConditions.visibilityOf(expectedFName));
        wait.until(ExpectedConditions.visibilityOf(expectedLName));
        Assert.assertEquals(firstName.toLowerCase(), expectedFName.getText().toLowerCase());
        Assert.assertEquals(lastName.toLowerCase(), expectedLName.getText().toLowerCase());


    }
    @Test
    public void quickSrcByAddress(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("(//span[@id='Title'])[2]")).click();
        driver.findElement(By.id("txtHouseNumber")).click();
        driver.findElement(By.id("txtHouseNumber")).clear();
        WebElement houseNum= driver.findElement(By.id("txtHouseNumber"));
        wait.until(ExpectedConditions.visibilityOf(houseNum)).sendKeys("635");
        driver.findElement(By.id("txtStreetName")).clear();
        WebElement streetAdd =  driver.findElement(By.id("txtStreetName"));
        wait.until(ExpectedConditions.visibilityOf(streetAdd)).sendKeys("Hall rd");
        WebElement searchBtn=  driver.findElement(By.cssSelector("button#btnSearch > div"));
        wait.until(ExpectedConditions.visibilityOf(searchBtn)).click();
//        WebElement expAddFName = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[2]"));
//        WebElement expAddLName = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
        WebElement row1 = driver.findElement(By.id("btn_table100_row1"));
        Assert.assertTrue(row1.getText().contains("635"));
//        wait.until(ExpectedConditions.visibilityOf(expAddFName));
//        wait.until(ExpectedConditions.visibilityOf(expAddLName));
//        String firstAdd = "EMMA";
//        String lastAdd= "HENDRICKSON";
//        Assert.assertEquals(firstAdd,expAddFName.getText()  );
//        Assert.assertEquals(lastAdd, expAddLName.getText());
    }
    @Test
    public void quickSrcByID(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement addressTab =  driver.findElement(By.cssSelector("[role='tab']:nth-of-type(1) #Title"));
        wait.until(ExpectedConditions.visibilityOf(addressTab)).click();
        WebElement stateId = driver.findElement(By.cssSelector("input#txtVoterId"));
        wait.until(ExpectedConditions.visibilityOf(stateId));
        stateId.sendKeys("NY000000000052324382");
        WebElement srchBtn=  driver.findElement(By.cssSelector("button#btnSearch > div"));
        wait.until(ExpectedConditions.visibilityOf(srchBtn)).click();
//        WebElement idFName = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[2]"));
//        WebElement idLName= driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
//        wait.until(ExpectedConditions.visibilityOf(idFName));
//        wait.until(ExpectedConditions.visibilityOf(idLName));
//        Assert.assertEquals("james", idFName.getText().toLowerCase());
//        Assert.assertEquals("bullis", idLName.getText().toLowerCase());
    }
    @Test
    public void quickSrcByDOB() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement srchByIdTab =  driver.findElement(By.cssSelector("[role='tab']:nth-of-type(1) #Title"));
        wait.until(ExpectedConditions.visibilityOf(srchByIdTab)).click();
        WebElement bDateField =driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        wait.until(ExpectedConditions.visibilityOf(bDateField));
        bDateField.sendKeys("02/24/1941", Keys.ENTER);
        WebElement srchButton =  driver.findElement(By.cssSelector("button#btnSearch > div"));
        wait.until(ExpectedConditions.visibilityOf(srchButton)).click();
//        WebElement dateOfBirthField= driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[5]"));
//        wait.until(ExpectedConditions.visibilityOf(dateOfBirthField));
//        Assert.assertEquals("02/24/1941",dateOfBirthField.getText());
//        System.out.println(dateOfBirthField.getText());
    }

    @Test
    public void voterMgtSchByName() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        WebElement voteMgtBtn =  driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text"));
        wait.until(ExpectedConditions.visibilityOf(voteMgtBtn)).click();
        String firstName = "Marjorie";
        String lastName = "Rozelle";
        WebElement fiName =   driver.findElement(By.id("txtSearchFirstName"));
        wait.until(ExpectedConditions.visibilityOf(fiName));
        fiName.sendKeys(firstName);
        WebElement laName = driver.findElement(By.id("txtSearchLastName"));
        wait.until(ExpectedConditions.visibilityOf(laName));
        laName.sendKeys(lastName);
        WebElement btnSearch =   driver.findElement(By.xpath("//button[@id='btnSearch']/div"));
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
//        WebElement fName=driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[5]"));
//        WebElement lName=driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
        Thread.sleep(1000);
        WebElement row1 = driver.findElement(By.id("btn_table1_row1"));
        wait.until(ExpectedConditions.visibilityOf(row1)).click();
    }
    @Test
    public void voterMgtSchByHouseNum() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        WebElement expandBtn=driver.findElement(By.id("btnExpand"));
        expandBtn.click();
        WebElement houseNum = driver.findElement(By.xpath("//input[@placeholder='Enter Here' and  @id='txtSearchHouseNumber']"));
        houseNum.sendKeys("222");
        WebElement searchButton=  driver.findElement(By.xpath("//button[@id='btnSearch']/div"));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

    }

    @Test
    public void voterMgtSchByID() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        WebElement stateId = driver.findElement(By.xpath("//input[@placeholder='Enter Here' and  @id='txtSearchVoterId']"));
        stateId.sendKeys("122998");
        driver.findElement(By.cssSelector("button#btnSearch > div")).click();
        Thread.sleep(1000);
        WebElement idFName = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[5]"));
        WebElement idLName= driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
        Assert.assertEquals("stephanie", idFName.getText().toLowerCase());
        Assert.assertEquals("staley", idLName.getText().toLowerCase());


    }
    @Test
    public void voterMgtSchByDOB() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        WebElement bDateField =driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        bDateField.sendKeys("02/24/1941", Keys.ENTER);
        driver.findElement(By.cssSelector("button#btnSearch > div")).click();
//        Thread.sleep(1000);
//        WebElement dobField= driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[7]"));
//        Assert.assertEquals("02/24/1941",dobField.getText());

    }
    @Test
    public void voterMgtSchByPartialName() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        String firstName = "Ma";
        driver.findElement(By.id("txtSearchFirstName")).sendKeys(firstName);
        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        WebElement expectedFName=driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[5]"));

        String fNameContainer = expectedFName.getText().toLowerCase();
        String fNameLower = firstName.toLowerCase() ;
        //Thread.sleep(2000);
        Assert.assertTrue( fNameContainer.contains(fNameLower));


    }
    @Test
    public void updateVoterLName() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        WebElement lNameField = driver.findElement(By.cssSelector("input[id='txtSearchLastName']"));
        lNameField.sendKeys("Tawabi");
        Thread.sleep(2000);
       driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
        WebElement lNameExistence = driver.findElement(By.xpath("//tr[@id='btn_table1_row1']//td[4]"));
        wait.until(ExpectedConditions.visibilityOf(lNameExistence));
        String lNamTxt=lNameExistence.getText();
        if (!lNamTxt.equalsIgnoreCase("Tawabi")){
            WebElement resetBtn = driver.findElement(By.cssSelector("button[id='btnReset']"));
            Thread.sleep(1000);
            resetBtn.click();
            Thread.sleep(4000);
            System.out.println("Tawabi does not exist ");
            WebElement lastNameHolder = driver.findElement(By.cssSelector("input[id='txtSearchLastName']"));
            lastNameHolder.sendKeys("Norman");
            driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
            Thread.sleep(2000);
            WebElement row1 = driver.findElement(By.id("btn_table1_row1"));
            row1.click();
            WebElement editBtn = driver.findElement(By.id("btn_tab1_section1_edit"));
            editBtn.click();
            WebElement lastNameField = driver.findElement(By.id("txtLastName"));
            lastNameField.clear();
            lastNameField.sendKeys("Tawabi");
            WebElement saveBtn =  driver.findElement(By.id("btn_tab1_section1_save"));
            Actions actions = new Actions(driver);
            js.executeScript("arguments[0].click();", saveBtn);
            Thread.sleep(2000);
            WebElement fullName = driver.findElement(By.cssSelector("h1[class='voter-name']"));
            String lNameFrmOverview=fullName.getText();
            String expectedLName=lNameFrmOverview.substring(lNameFrmOverview.lastIndexOf(" "));
            // String finalLName = expectedLName.toLowerCase();
            Assert.assertEquals("Tawabi",expectedLName.trim());

        } else if (lNamTxt.equalsIgnoreCase("Tawabi")){

            driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
            Thread.sleep(1000);

         js.executeScript("window.scrollBy(0,700)");
            WebElement row1 = driver.findElement(By.id("btn_table1_row1"));
//            //WebElement row = driver.findElement(By.id("//tr[@id='btn_table1_row1']"));
           row1.click();

           Thread.sleep(2000);
           // js.executeScript("window.scrollBy(0,700)");
            WebElement editBtn = driver.findElement(By.id("btn_tab1_section1_edit"));
            editBtn.click();
            WebElement lastNameField = driver.findElement(By.id("txtLastName"));
            lastNameField.clear();
            lastNameField.sendKeys("Norman");
            Thread.sleep(5000);
            WebElement sveBtn =  driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(1000);
            WebElement fullName = driver.findElement(By.cssSelector("h1[class='voter-name']"));
            Thread.sleep(1000);
            String lNameFrmOverview=fullName.getText();
            String expectedLName=lNameFrmOverview.substring(lNameFrmOverview.lastIndexOf(" "));
            System.out.println("actualFstName = " + expectedLName);
            Assert.assertEquals("Norman",expectedLName.trim());

        }



   }
    @Test
    public void updateVoterPolParty() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        WebElement lNameField = driver.findElement(By.cssSelector("input[id='txtSearchLastName']"));
        lNameField.sendKeys("Hicks");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
        WebElement row1 = driver.findElement(By.id("btn_table1_row1"));
        row1.click();
        WebElement editBtn = driver.findElement(By.id("btn_tab1_section1_edit"));
        editBtn.click();
        js.executeScript("window.scrollBy(0,400)");
        WebElement politicalParty = driver.findElement(By.cssSelector("nz-select#ddlRegisteredPoliticalParty  .ant-select-selection__rendered"));
        String polPartyTxt= politicalParty.getText();
        System.out.println("polPartyTxt = " + polPartyTxt);
        Thread.sleep(1000);


        if (polPartyTxt.equalsIgnoreCase("Democratic party")){
            WebElement polPartyDrop = driver.findElement(By.cssSelector("nz-select#ddlRegisteredPoliticalParty  .ant-select-selection__rendered"));
            polPartyDrop.click();
            WebElement repParty= driver.findElement(By.xpath("//ul[@role='menu']//li[2]"));
            repParty.click();
            js.executeScript("window.scrollBy(0,-1000)");
            Thread.sleep(2000);
            //WebElement s1Btn =  driver.findElement(By.id("btn_tab1_section1_save"));
            // js.executeScript("arguments[0].click();", s2Btn);
            // s2Btn.click();
//            Actions actions = new Actions(driver);
//            actions.click(s1Btn);
            WebElement sveBtn =  driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(1000);

        } else if (polPartyTxt.equalsIgnoreCase("Republican Party")){
            WebElement polPartyDropdown = driver.findElement(By.cssSelector("nz-select#ddlRegisteredPoliticalParty  .ant-select-selection__rendered"));
            polPartyDropdown.click();
            WebElement demoParty= driver.findElement(By.xpath("//ul[@role='menu']//li[1]"));
            demoParty.click();
            js.executeScript("window.scrollBy(0,-1000)");
            Thread.sleep(1000);
//            WebElement s2Btn =  driver.findElement(By.id("btn_tab1_section1_save"));
//            //js.executeScript("arguments[0].click();", s2Btn);
//            Actions actions = new Actions(driver);
//            actions.click(s2Btn);
            WebElement sveBtn =  driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(2000);
            // s2Btn.click();



        }


    }

    @Test
    public void updateVoterStatus() throws InterruptedException {
        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//div[@id='maincontent']/section[@class='alain-default__content']/app-voter-management[@class='ng-star-inserted']//app-list-page//span[.='Show Only Active']")).click();

        WebElement lNameField = driver.findElement(By.cssSelector("input[id='txtSearchLastName']"));
        lNameField.sendKeys("HENDRICKSON");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
        WebElement row1 = driver.findElement(By.id("btn_table1_row1"));
        row1.click();
        WebElement editBtn = driver.findElement(By.id("btn_tab1_section1_edit"));
        editBtn.click();
        js.executeScript("window.scrollBy(0,600)");
        WebElement statusField = driver.findElement(By.cssSelector("nz-select#ddlVoterStatus  .ant-select-selection__rendered"));
        String statusTxt= statusField.getText();
        System.out.println("statusTxt = " + statusTxt);
        if (statusTxt.equalsIgnoreCase("active")){
            WebElement voterStsRsn=driver.findElement(By.xpath("// nz-select[@id='ddlVoterStatusReason']"));
            Thread.sleep(1000);
            Actions actions = new Actions(driver);
            actions.moveToElement(voterStsRsn).click().build().perform();
            WebElement dropdownValue= driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(6)"));
            wait.until(ExpectedConditions.elementToBeClickable(dropdownValue)).click();
            Thread.sleep(1000);
            statusField.click();
            WebElement inActiveOption = driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(3)"));
            inActiveOption.click();
            WebElement sveBtn =  driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(1000);

        } else {
            WebElement reasonDropdown2 = driver.findElement(By.cssSelector("nz-select#ddlVoterStatus  .ant-select-selection__rendered"));
            reasonDropdown2.click();
            WebElement activeOption = driver.findElement(By.cssSelector("ul[role='menu'] > li:nth-of-type(1)"));
            activeOption.click();
            WebElement sveBtn =  driver.findElement(By.id("btn_tab1_section1_save"));
            js.executeScript("arguments[0].click();", sveBtn);
            Thread.sleep(1000);

        }

    }



    @AfterMethod
    public void afterTest(){
        driver.close();
    }
//
//    @Test
//    public void testSeleniumLoadTesting() throws Exception {
//
//
//
////        driver.get("https://demo.nextvote.com/#/passport/login");
////        driver.findElement(By.id("txtUserName")).clear();
////        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
////        driver.findElement(By.id("txtPassword")).clear();
////        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
////        driver.findElement(By.xpath("//div/div")).click();
////        driver.findElement(By.xpath("//button[@id='btnLogin']/div")).click();
//        driver.findElement(By.xpath("//button[@id='btnChenango']/div")).click();
//        driver.findElement(By.id("txtFirstName")).click();
//        driver.findElement(By.id("txtFirstName")).clear();
//        driver.findElement(By.id("txtFirstName")).sendKeys("sam");
//        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
//        driver.findElement(By.cssSelector("i.anticon.user-icon.anticon-logout > svg")).click();
//        driver.findElement(By.id("txtUserName")).clear();
//        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
//        driver.findElement(By.id("txtPassword")).clear();
//        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
//    }
//    @Test
//    public void testLoginCreateUser() throws Exception {
////        driver.get("https://demo.nextvote.com/#/passport/login");
////        driver.findElement(By.id("txtUserName")).clear();
////        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
////        driver.findElement(By.id("txtPassword")).clear();
////        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
////        driver.findElement(By.xpath("//div/div")).click();
//        //driver.findElement(By.xpath("//button[@id='btnLogin']/div")).click();
//        driver.findElement(By.xpath("//button[@id='btnChenango']/div")).click();
//        driver.findElement(By.xpath("//li[@id='Function_Voters']/a/span")).click();
//        driver.findElement(By.xpath("//li[@id='Function_Voters_VoterManagement']/a/span")).click();
//        //driver.findElement(By.linkText("New")).click();
//        //li#ddlBtn_new > a
//
//        driver.findElement(By.id("btnNew")).click();
//        driver.findElement(By.cssSelector("li#ddlBtn_new > a")).click();
//        driver.findElement(By.id("txtLastName")).clear();
//        driver.findElement(By.id("txtLastName")).sendKeys("Cheese");
//        driver.findElement(By.id("txtFirstName")).clear();
//        driver.findElement(By.id("txtFirstName")).sendKeys("Larry");
////        driver.findElement(By.xpath("//div[2]")).click();
////        driver.findElement(By.linkText("1980")).click();
//        //driver.findElement(By.xpath("//div[@id='cdk-overlay-4']/div/date-range-popup/div/div/div/div/inner-popup/div/date-table/table/tbody/tr[5]/td[4]/div")).click();
//        //driver.findElement(By.id("txtDLNumber/StateID")).click();
//        driver.findElement(By.id("txtDLNumber/StateID")).clear();
//        driver.findElement(By.id("txtDLNumber/StateID")).sendKeys("12345678");
////        driver.findElement(By.xpath("//button[@id='btn_popup1_ok']/div")).click();
//        //driver.findElement(By.cssSelector("i.anticon.user-icon.anticon-logout > svg")).click();
//        driver.findElement(By.id("btn_popup1_ok")).click();
//
//    }
//
//    @Test
//    public void testUntitledTestCase() throws Exception {
//
//       // driver.findElement(By.xpath("//button[@id='btnLogin']/div")).click();
//        driver.findElement(By.xpath("//button[@id='btnChenango']/div")).click();
//        driver.findElement(By.xpath("//li[@id='Function_Elections']/a/span")).click();
//        driver.findElement(By.xpath("//li[@id='Function_Elections_Candidates']/a/span")).click();
//        driver.findElement(By.id("txtSearchFirst")).clear();
//        driver.findElement(By.id("txtSearchFirst")).sendKeys("Jennifer");
//        driver.findElement(By.id("txtSearchLast")).click();
//        driver.findElement(By.id("txtSearchLast")).clear();
//        driver.findElement(By.id("txtSearchLast")).sendKeys("Akshar");
//        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
//        //driver.findElement(By.xpath("//tr[@id='btn_table1_row1']/td[3]/span[2]/span")).click();
//        WebElement votersBtn =  driver.findElement(By.cssSelector("li#Function_Voters  .ng-star-inserted.sidebar_arrow")   );
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(votersBtn)).click();
//
//
//
//        driver.findElement(By.cssSelector("li#Function_Voters_VoterManagement  .sidebar-nav__item-text")).click();
//        driver.findElement(By.id("txtSearchFirstName")).click();
//        driver.findElement(By.id("txtSearchFirstName")).clear();
//        driver.findElement(By.id("txtSearchFirstName")).sendKeys("James");
//        driver.findElement(By.id("txtSearchLastName")).click();
//        driver.findElement(By.id("txtSearchLastName")).clear();
//        driver.findElement(By.id("txtSearchLastName")).sendKeys("Bullis");
//        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
//
//        driver.findElement(By.xpath("//li[@id='Function_Elections']/a/span")).click();
//        driver.findElement(By.xpath("//li[@id='Function_Elections_Offices']/a/span")).click();
//        driver.findElement(By.id("txtSearchOfficeName1")).click();
//        driver.findElement(By.id("txtSearchOfficeName1")).clear();
//        driver.findElement(By.id("txtSearchOfficeName1")).sendKeys("county clerk");
//        driver.findElement(By.xpath("//button[@id='btnSearch']/div")).click();
//        driver.findElement(By.cssSelector("i.anticon.user-icon.anticon-logout > svg")).click();
//        Thread.sleep(4000);
//    }
//
//
//
//
//
//
//    @After
//    public void afterTest(){
//       driver.close();
//    }
//    @Test
//    public void test3(){
////
////        WebElement NextYrBtn = driver.findElement(By.cssSelector("div > a:nth-of-type(4)"));
//        WebElement bDateField =driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
//       // bDateField.click();
//        bDateField.sendKeys("02/24/1941", Keys.ENTER);
//        driver.findElement(By.id("btnSearch")).click();
//        System.out.println(driver.findElement(By.xpath("//tr[@id='btn_table1_row1']/td[5]")).getText());
//
//    }
//    @Test
//    public void testCreateAVoter() throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        driver.get("https://demo.nextvote.com/#/passport/login");
//        driver.findElement(By.id("txtUserName")).clear();
//        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
//
//        driver.findElement(By.xpath("//div/div")).click();
//        driver.findElement(By.id("txtPassword")).clear();
//        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
//        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
//       WebElement chenagoBtn =  driver.findElement(By.xpath("//button[@id='btnChenango']/div"));
//       wait.until(ExpectedConditions.elementToBeClickable(chenagoBtn)).click();
//

    // WebElement emsID =  driver.findElement(By.xpath("/html//sv-container[@id='sv']/div/sv[8]//span[@id='lblVundefined']"));

    //wait.until(ExpectedConditions.visibilityOf(emsID )).getText();
    // System.out.println(wait.until(ExpectedConditions.visibilityOf(emsID)).getText());
    // driver.findElement(By.cssSelector(".anticon.anticon-logout.user-icon > svg")).click();
//        driver.findElement(By.xpath("//div[@id='cdk-overlay-4']/div/date-range-popup/div/div/div/calendar-input/div/div/input")).clear();
//        driver.findElement(By.xpath("//div[@id='cdk-overlay-4']/div/date-range-popup/div/div/div/calendar-input/div/div/input")).sendKeys("06/04/1965");
//        driver.findElement(By.xpath("//button[@id='btn_popup1_ok']/div")).click();
//        driver.findElement(By.xpath("//li[@id='Function_Voters_WorkItems']/a/span")).click();
//        driver.findElement(By.xpath("//tr[@id='btn_table1_row24']/td[6]")).click();
//        driver.findElement(By.xpath("//button[@id='btnFalsePositive']/div")).click();
//        driver.findElement(By.cssSelector("em.anticon.user-icon.anticon-logout > svg > path")).click();
//        driver.findElement(By.id("txtUserName")).clear();
//        driver.findElement(By.id("txtUserName")).sendKeys("nextvote");
//        driver.findElement(By.id("txtPassword")).clear();
//        driver.findElement(By.id("txtPassword")).sendKeys("NextVote@777");
//
//        WebElement workItemLink = driver.findElement(By.xpath("//li[@id='Function_Voters_WorkItems']"));
//       wait.until(ExpectedConditions.elementToBeClickable(workItemLink)).click();
//
//
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        //js.executeScript("arguments[0].scrollIntoView();", lName);
//          js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        Thread.sleep(3000);
//        WebElement lName = driver.findElement(By.xpath("//span[text()='"+lastName+"']"));
//          Assert.assertEquals(lName.getText(), lastName);
//        Thread.sleep(5000);
//        WebElement  nContainer = driver.findElement(By.cssSelector("nz-col:nth-of-type(1) > .voter-name"));
//
//        ////h1[@class='voter-name']
////        WebElement SpinningWheel = driver.findElement(By.xpath("//div[@class='ant-spin ant-spin-spinning')"));
////        wait.until(ExpectedConditions.invisibilityOf(SpinningWheel));
//        System.out.println(nContainer.getText());
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(nContainer)).getText().contains(lastName));
//
////        WebElement nameContainer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='voter-name']")));
////                //driver.findElement(By.cssSelector("nz-col:nth-of-type(1) > .voter-name"));
//////
////
////        Assert.assertTrue(nameContainer1.getText().contains(lastName));
//        //Thread.sleep(4000);
//        driver.close();
    //  }




}
