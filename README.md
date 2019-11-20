Ryan Kenney's Swagger Example
----------------

This is just a simple example of Swagger, applied to Java JAX-RS/JAX-B services,
and hosting its own Swagger-UI.

Caveats:

* This pulls the latest Swagger UI via NPM, embedded as a Maven task
* This uses Swagger 1.x. Swagger 2.x TBD.
* This has been tested on Tomcat. As memory serves me,
  I had to exclude some transitive dependencies to get things working in JBoss.
