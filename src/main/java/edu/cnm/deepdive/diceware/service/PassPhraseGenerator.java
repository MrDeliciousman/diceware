package edu.cnm.deepdive.diceware.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PassPhraseGenerator implements Generator {

  private List<String> words;
  private Random rng;

  public PassPhraseGenerator(WordSource words, Random rng) {
    this.words = new ArrayList<>(words.getWords());
    this.rng = rng;
  }

  @Override
  public String[] generator(int length) {
    String[] passphrase = new String[length];
    for (int i = 0; i < passphrase.length; i++) {
      passphrase[i] = words.get(rng.nextInt(words.size()));
    }
    return passphrase;
  }
}
