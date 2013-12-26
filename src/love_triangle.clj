(ns love_triangle)

(defn to-binary [& ns]
  (let [convert (fn convert [n]
                  (when-not (zero? n)
                    (cons (bit-and n 1) (lazy-seq (convert (bit-shift-right n 1))))))
        bs (map #(reverse (convert %)) ns)
        max-bitmap-size (reduce #(max %1 (count %2)) 0 bs)
        pad (fn [bitmap p]
              (concat (repeat (- p (count bitmap)) 0) bitmap))]
    (map #(pad % max-bitmap-size) bs)
  )
)

(defn area [mine]
  nil
)
