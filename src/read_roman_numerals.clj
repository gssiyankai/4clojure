(ns read_roman_numerals)

(defn read-roman-numeral [number]
  (let [symbols { \I 1, \V 5, \X 10, \L 50, \C 100, \D 500, \M 1000 }]
    (reduce + (map symbols number))
  )
)