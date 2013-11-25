(ns read_roman_numerals)

(defn read-roman-numeral [number]
  (let [symbols { \I 1, \V 5, \X 10, \L 50, \C 100, \D 500, \M 1000 }]
    (->> (partition 2 1  nil number)
         (reduce (fn [acc [num next-num]]
                   (let [val (symbols num)
                         next-val (if (nil? next-num) 0 (symbols next-num))
                         op (if (< val next-val) - +)]
                     (op acc val))) 0)
      )
  )
)