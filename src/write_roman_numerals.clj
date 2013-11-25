(ns write_roman_numerals)


(defn write-roman-numeral [number]
  (let [symbols-base-5 [\V, \L, \D]
        symbols-base-10 [\I, \X, \C, \M]
        digits (fn digits [n]
                 (if (> n 0) (conj (digits (int(/ n 10))) (mod n 10)) []))
        digits-number (digits number)
        num-digits (count digits-number)]
    (->> (range num-digits)
         (map (fn [index]
                (let [digit (digits-number index)
                      digit-index (dec (- num-digits index))
                      next-digit-index (inc digit-index)
                      symbol (fn [symbols digit-index]
                               (if (> (count symbols) digit-index) (symbols digit-index) nil))
                      symbol-1 (symbol symbols-base-10 digit-index)
                      symbol-5 (symbol symbols-base-5 digit-index)
                      symbol-10 (symbol symbols-base-10 next-digit-index)
                      convert (fn convert [digit symbol-1 symbol-5 symbol-10]
                                (cond (=  digit 9) [symbol-1 symbol-10]
                                      (>= digit 5) (cons symbol-5 (convert (- digit 5) symbol-1 symbol-5 symbol-10))
                                      (=  digit 4) [symbol-1 symbol-5]
                                      :else       (repeat digit symbol-1)))]
                  (convert digit symbol-1 symbol-5 symbol-10)
                )))
         (map #(clojure.string/join %))
         (apply str)
    )
  )
)