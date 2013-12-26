(ns squares_squared)

(defn squares [start end]
  (when (<= start end)
    (cons start (lazy-seq (squares (* start start) end)))
  )
)

(defn transform [start end]
  nil
)