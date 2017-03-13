# sc-simple
Simple Spring Cloud app with Eureka and Hystrix support

# get sc-simple up and running

- git clone https://github.com/dflick-pivotal/sc-simple.git
- cd sc-simple
- mvn package
- cf push -f manifest-services.yml
- cf cups service-registry -p '{"uri":"http://<EUREKA_ROUTE>"}'
- cf push -f manifest-apps.yml
- load circuit-breaker app in browser
  - insert in the field http://<UI_ROUTE/hystrix.stream>
  - click monitor stream
- load ui app in browser - you should get: "Hello from: service"
- stop services app
- load ui app in browser - you should get: "This is the hystrix fallback!!!"
