.DEFAULT_GOAL := build-run

setup:
	chmod +x ./gradlew
	./gradlew wrapper --gradle-version 8.7

clean:
	chmod +x ./gradlew
	./gradlew clean

build:
	chmod +x ./gradlew
	./gradlew clean build

install:
	make -C app install

run-dist:
	chmod +x ./gradlew
	./build/install/app/bin/app

run:
	chmod +x ./gradlew
	./gradlew run

test:
	chmod +x ./gradlew
	./gradlew test

report:
	chmod +x ./gradlew
	./gradlew jacocoTestReport

checkstyleMain:
	chmod +x ./gradlew
	./gradlew checkstyleMain

check-deps:
	chmod +x ./gradlew
	./gradlew dependencyUpdates -Drevision=release

build-run: build run

.PHONY: build