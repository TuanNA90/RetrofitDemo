# RetrofitDemo
Retrofit Demo 2.0

#### The following to your app/build.gradle file:
```
    dependencies {
        compile 'com.google.code.gson:gson:2.4'
        compile 'com.squareup.retrofit:retrofit:2.0.0-beta2'
        compile 'com.squareup.retrofit:converter-gson:2.0.0-beta2'  
        compile 'com.squareup.okhttp:okhttp:2.4.0'
    }
```
###Creating the Retrofit instance
###### To send out network requests to an API, we need to use the Retrofit builder class and specify the base URL for the service.
```
    public static final String BASE_URL = "https://api.github.com";
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
```
###Define the Endpoints
###### With Retrofit 2, endpoints are defined inside of an interface using special retrofit annotations to encode details about the parameters and request method. In addition, the return value is always a parameterized Call<T> object such as Call<User>. If you do not need any type-specific response, you can specify return value as simply Call<Response>.
###### For instance, the interface defines each endpoint in the following way:
```
    public interface Api {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter
    
        @GET("/users/{username}")
        Call<User> getUser(@Path("username") String username);
    
        @GET("/group/{id}/users")
        Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);
    
        @POST("/users/new")
        Call<User> createUser(@Body User user);
    }
```
###Accessing the API
###### We can bring this all together by constructing a service leveraging the **"Api"** interface with the defined endpoints:
```
    Api apiService =
    retrofit.create(Api.class);
```
###### If we want to consume the API asynchronously, we call the service as follows:
```
    String username = "tuanna-ansiantech";
    Call<User> call = apiService.getUser(username);
    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(Response<User> response, Retrofit retrofit) {
            int statusCode = response.code();
            User user = response.body();  
        }
    
        @Override
        public void onFailure(Throwable t) {
            // Log error here since request failed
        }
    });
```
#### Notice: 
###### that in Retrofit 2 the interceptor has to be added to a custom OkHttpClient. In Retrofit 1, it could be set directly by the builder class.
