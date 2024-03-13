-- AlterTable
ALTER TABLE "projects" ALTER COLUMN "image" DROP NOT NULL;

-- CreateTable
CREATE TABLE "workers" (
    "id" TEXT NOT NULL,
    "username" TEXT NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP(3) NOT NULL,

    CONSTRAINT "workers_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "_ProjectToWorker" (
    "A" TEXT NOT NULL,
    "B" TEXT NOT NULL
);

-- CreateIndex
CREATE UNIQUE INDEX "_ProjectToWorker_AB_unique" ON "_ProjectToWorker"("A", "B");

-- CreateIndex
CREATE INDEX "_ProjectToWorker_B_index" ON "_ProjectToWorker"("B");

-- AddForeignKey
ALTER TABLE "_ProjectToWorker" ADD CONSTRAINT "_ProjectToWorker_A_fkey" FOREIGN KEY ("A") REFERENCES "projects"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "_ProjectToWorker" ADD CONSTRAINT "_ProjectToWorker_B_fkey" FOREIGN KEY ("B") REFERENCES "workers"("id") ON DELETE CASCADE ON UPDATE CASCADE;
