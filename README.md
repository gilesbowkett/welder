# welder

A Clojure library which gives you high-scoring words for the iOS game
W.E.L.D.E.R.

## Usage

Mega primitive right now. Define `gold-tiles` in `core.clj` and start it up in
the REPL. Get your best options by doing something like `(take 20 lengthwise)`.

Best strategy I've found for W.E.L.D.E.R. is to make mega-high-scoring words
with as many gold/diamond/etc tiles as possible, so this gives you the longest
possible words you can create for any given assortment of gold tiles.

## License

Copyright © 2014 Giles Bowkett

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

