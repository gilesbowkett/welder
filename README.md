# welder

A Clojure library which gives you high-scoring words for the iOS game WELDER.

## Usage

Start it up in the REPL. If you have "a," "b," and "c" as your gold tiles,
`(def gold-tiles ["a" "b" "c"])`. You get the idea. Get your best options by
doing something like `(take 20 (lengthwise))`.

The best strategy I've found for WELDER is to make mega-high-scoring words
with as many gold/diamond/etc tiles as possible, so this gives you the longest
possible words you can create for any given assortment of gold tiles.

If you want the word to end or begin with a particular letter, you can filter
the set of viable words through an appropriate regex. For instance, if you want
your word to end in the letter R:

    (filter #(re-find #"r$" %) (golden-words))

Even when you've got a great word you want to use, WELDER's still risky, because
it has a really demented idea of what words exist in the English language, and
will frequently thwart you with that obscure knowledge (if "knowledge" is even
the right word for it). So, if you want to find out what "words" (in WELDER's
word list) exist within a word you're aiming to make, do this:

    (risks "villainy") ; => ("vill" "villa" "villain" "lain")

## License

Copyright © 2014-2015 Giles Bowkett

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

