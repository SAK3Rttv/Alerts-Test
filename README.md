# Selenium: Advanced JavaScript Alert Automation

This project demonstrates a comprehensive suite for handling different types of **JavaScript Alerts** on [The Internet (HerokuApp)](https://the-internet.herokuapp.com/javascript_alerts). It validates the entire lifecycle of an alert: triggering, interacting, and verifying the result on the webpage.

## 🎯 Project Objectives
*   **Alert Types**: Handle JS Alert (Simple), JS Confirm (OK/Cancel), and JS Prompt (Text Input).
*   **Context Switching**: Use `driver.switchTo().alert()` to manage browser-level pop-ups.
*   **Result Verification**: Use TestNG Assertions to verify that the webpage correctly displays the outcome of the alert interaction.

## 🛠️ Implementation Details
The suite is organized into three prioritized test cases:

1.  **Priority 1: JS Prompt (`testJsPrompt`)**
    *   Clicks the prompt button, enters custom text ("Abdullah A. Muhaisen"), and accepts the alert.
    *   **Assertion**: Confirms the result label contains the exact name entered.
2.  **Priority 2: JS Alert (`testJsAlert`)**
    *   Clicks the basic alert button and accepts it.
    *   **Assertion**: Verifies the result message confirms a successful click.
3.  **Priority 3: JS Confirm (`testJsConfirm`)**
    *   Clicks the confirmation button and dismisses (cancels) it.
    *   **Assertion**: Verifies the result message contains "Cancel".

## 🚀 How to Run

### Installation & Cloning
```bash
git clone https://github.com/SAK3Rttv/Alerts-Test.git
```

### Execution
1.  Open the project in **Eclipse**.
2.  Navigate to the `ch8_6` package.
3.  Right-click `AlretsTest.java` and select **Run As > TestNG Test**.

## 💻 Code Highlight
```java
// Professional Prompt Handling & Verification
Alert alert = driver.switchTo().alert();
alert.sendKeys(myName);
alert.accept();

WebElement resultE = driver.findElement(By.id("result"));
Assert.assertTrue(resultE.getText().contains(myName), "Result text mismatch!");
```

## 📁 Project Structure
*   **Test Class**: `AlretsTest.java`
*   **Frameworks**: Selenium WebDriver 4.x, TestNG 7.x, WebDriverManager.
