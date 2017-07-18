
public class PokemonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex  newPokemon=new Pokedex();
		Pokemon pok1=newPokemon.createPokemon("Balbauser", 100, "water");
		
		newPokemon.createPokemon("AAA", 100, "aaaaa");
		newPokemon.createPokemon("BBBB", 100, "bbbb");
		newPokemon.createPokemon("CCCC", 100, "ccc");
		
		String info=newPokemon.pokemonInfo(pok1);
		System.out.println(info);
		
		newPokemon.attackPokemon(pok1);
		newPokemon.attackPokemon(pok1);
		newPokemon.attackPokemon(pok1);
		
		
		
		int resultCount= Pokemon.getCount();
		System.out.println(resultCount);
		
	}

}
