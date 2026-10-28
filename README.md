# Spring Boot · Docker · Jenkins

A small HTTP service demonstrating a build-and-test pipeline and a non-root Java container.
`GET /test` returns `Hello World`. No database is required.

## Run locally

Requires JDK 17, Maven 3.6.3+, and Docker with Compose v2.

```sh
mvn --batch-mode clean verify
docker compose up --build -d
curl --fail http://localhost:8084/test
docker compose down
```

The published port is bound to localhost. The endpoint is an unauthenticated learning demo.

## Jenkins

Create a Pipeline from SCM pointing to this repository. Configure the Maven installation
as `maven`; the Linux agent needs JDK 17, Docker access, and Compose v2.
The pipeline checks out the exact SCM revision, runs tests, publishes JUnit results,
builds `jenkins-hello:$BUILD_NUMBER`, and validates Compose. It does not start services
or deploy on the build agent. Choose an image explicitly for a separate deployment:

```sh
APP_IMAGE=jenkins-hello:42 docker compose up -d --no-build
```

The existing Spring Boot 3.1.4 baseline is retained for this compatibility repair;
upgrading dependencies and performing a vulnerability review remain follow-up work.
Java requirements: [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/3.1.4/reference/html/getting-started.html#getting-started.system-requirements).
Pipeline reference: [Jenkins syntax](https://www.jenkins.io/doc/book/pipeline/syntax/).
