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
        dim (int (Math/ceil (Math/sqrt size)))]
    (concat digits (repeat (- (square dim) size) \*))
  )
)

(defn transform [start end]
  nil
)
