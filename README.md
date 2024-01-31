# POC for rest issues in keycloak extensions for keycloak 23.0.5

## Steps to reproduce

- navigate to ./rest and run `mvn clean verify; docker build -t keycloakpoc2305 .; docker run  -p 8080:8080 keycloakpoc2305`
- wait until keycloak has fully started and has initialized extensions
## containerresponse/requestfilters:

run the FilterTests in the org.sostrich.keycloak.pocs package

## multipart
run the MultipartTests in the org.sostrich.keycloak.pocs package
