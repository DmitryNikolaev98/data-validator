install:
	cd app && ./gradlew clean install

check-updates:
	cd app && ./gradlew dependencyUpdates

run:
	cd app && ./gradlew clean
	cd app && ./gradlew run

lint:
	cd app && ./gradlew checkstyleMain

build:
	cd app && ./gradlew clean build

report:
	cd app && ./gradlew jacocoTestReport

.PHONY: build