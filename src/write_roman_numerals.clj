(ns write_roman_numerals)

(defn digits [number]
  (if (> number 0) (conj (digits (int(/ number 10))) (mod number 10)) [])
)

(defn write-roman-numeral [number]
  (let [symbols { 1 \I, 5 \V, 10 \X, 50 \L, 100 \C, 500 \D, 1000 \M }
        symbols-base-10 [\I, \X, \C, \M]
        digits (digits number)
        num-digits (count digits)]
    (->> (range num-digits)
         (map (fn [index]
                (let [digit (digits index)
                      symbol (symbols (int (Math/pow 10 (dec (- num-digits index)))))]
                  (clojure.string/join (repeat digit symbol))
                )))
         (apply str)
    )
  )
)