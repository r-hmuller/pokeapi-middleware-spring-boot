# Get Pokemon Abilities

This is a simple project to connect to the PokeAPI and return all abilities that a Pokemon species have.

### How execute this project

This project can be executed with and without Docker. It depends only on gradle dependencies - no database or third-party
software are required.

#### Without Docker

From the project root folder, execute the following command: 

``` ./gradlew bootRun```

#### With Docker

First, build the image, running this command on the same folder with the Dockerfile: 

```docker build -t pokeapi-middleware .```

Then, just execute:

```docker run -p 8080:8080 pokeapi-middleware ```


### Routes

The current implementation only accepts one route:

`/abilities/<pokemon-name>` 

That will return a json with all the abilities:

```json 
{
	"names": [
		"blaze",
		"solar-power"
	]
}
```

If you pass an invalid Pokemon name, it will return a 404.
