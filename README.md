# :star: Validator
A simple text validation library

# :question: How can I add this to my project?
> Step 1: Add the JitPack repository to your build file
  ```gradle
  allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  ```
> Step 2: Add the dependency
  ```gradle
  dependencies {
	        implementation 'com.github.Ido-Barnea:Validator:1.0.1'
	}
  ```
  That's it!

# :fast_forward: Quick use
  ```kotlin
  Validator("My text") // Create a Validator object with your text
            .notEmpty() // Your Validations
	        .minLength(4)
            .addFailureCallback { errorMessage -> // failure callback (optional)
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
            .addSuccessCallback { // success callback (optional)
                Toast.makeText(this, "Succeeded", Toast.LENGTH_SHORT).show()
            }
            .validate() // Required, returns a boolean
  ```

# :book: List of validations:
- Not Empty (notEmpty)
- Min Length (minLength)
- Max Length (maxLength)
- Only Letters (onlyLetters)
- Only Numbers (onlyNumbers)
- Contains Uppercase (containsUppercase)
- Contains Lowercase (containsLowercase)
- Contains Digit (containsDigit)
- Contains Special Character (containsSpecial)
- Contains Substring (containsSubstring)
- Email (email)
- Phone number (phone)

# :briefcase: License
```
Copyright 2022 Ido Barnea

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
