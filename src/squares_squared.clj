(ns squares_squared)

(defn square [x]
  (* x x)
)

(defn squares [start end]
  (when (<= start end)
    (cons start (lazy-seq (squares (square start) end)))
  )
)

(defn tokenize [squares]
  (let [digits (mapcat str squares)
        size (count digits)
        dim (first (drop-while #(< (* % %) size) (range)))]
    (concat digits (repeat (- (square dim) size) \*))
  )
)

(defn transform [start end]
  nil
)
