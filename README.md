# About
This is a very simple example of how to use Retrofit2 using GET/POST/PUT/DELETE HTTP methods.

* This example serializes models using GsonConverterFactory
* Models uses Builder design pattern for simplified object creation in the example
* For this example I am using JSONPlaceholder

# RetrofitServices
RetrofitServices class in this example is useless but if this example will be developed
I will use this class for easy access to specific service from anywhere.

### Dependencies
```gradle
implementation 'com.google.code.gson:gson:(ver)'
implementation 'com.squareup.retrofit2:retrofit:(ver)'
compile group: 'com.squareup.retrofit2', name: 'converter-gson', version: '(ver)'
```

