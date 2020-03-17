# covid-web-api
COVID-19 Web Api

vm args: 
- CONTEXT_PATH (optional) - defaults to '/'
- PROFILES (comma separated list of profiles) - example values 'h2|postgres'
- DATABASE_URL - example: 'jdbc:postgresql://localhost/covid_db'
- DATABASE_USERNAME
- DATABASE_PW
- API_SERVICE_USERNAME (optional) - defaults to 'username' - api basic auth username
- API_SERVICE_PW (optional) - defaults to password - api basic auth pw
- LOG_FILE_NAME (optional) - defaults to 'app.log'
- LOG_FILE_PATH (optional) - defaults to './'

2 base controllers
- PersonController - subsequences should be created via this controller
- CodebookController - normalized code/name pairs (init by flyway)